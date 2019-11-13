package unac.selfcare.selfcareapp.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import unac.selfcare.selfcareapp.email.WebMessage;
import unac.selfcare.selfcareapp.model.*;
import unac.selfcare.selfcareapp.model.builders.CAABuilder;
import unac.selfcare.selfcareapp.model.builders.FraminghamBuilder;
import unac.selfcare.selfcareapp.model.builders.UserBuilder;
import unac.selfcare.selfcareapp.model.builders.UserToDxBuilder;
import unac.selfcare.selfcareapp.model.dtos.*;
import unac.selfcare.selfcareapp.model.web.Diagnostic;
import unac.selfcare.selfcareapp.model.web.Domain;
import unac.selfcare.selfcareapp.model.web.NIC;
import unac.selfcare.selfcareapp.model.web.NOC;
import unac.selfcare.selfcareapp.services.CommunicationService;
import unac.selfcare.selfcareapp.services.LogInServices;
import unac.selfcare.selfcareapp.services.SelfcareServices;
import unac.selfcare.selfcareapp.services.repositories.*;
import unac.selfcare.selfcareapp.services.repositories.web.DiagnosticRepository;
import unac.selfcare.selfcareapp.services.repositories.web.DomainRepository;
import unac.selfcare.selfcareapp.services.repositories.web.NicRepository;
import unac.selfcare.selfcareapp.services.repositories.web.NocRepository;
import unac.selfcare.selfcareapp.utils.FirstLogin;
import unac.selfcare.selfcareapp.utils.Utils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

@Service
public class ServicesImplementation implements SelfcareServices, LogInServices, CommunicationService {

    @Autowired
    private CAARepository caaRepository;
    @Autowired
    private DXRepository dxRepository;
    @Autowired
    private FraminghamRepository framinghamRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private HomeRepository homeRepository;
    @Autowired
    private DomainRepository domainRepository;
    @Autowired
    private NocRepository nocRepository;
    @Autowired
    private NicRepository nicRepository;
    @Autowired
    private DiagnosticRepository diagnosticRepository;
    @Autowired
    private JavaMailSender javaMailSender;
    @Autowired
    private WebMessageRepository webMessageRepository;
    @Autowired
    private AlarmaRepository alarmaRepository;

    Logger logger;

    @Value("${webMessage.to}")
    private String setTo;

    public ServicesImplementation(CAARepository caaRepository, DXRepository dxRepository,
                                  FraminghamRepository framinghamRepository, UserRepository userRepository, HomeRepository homeRepository,
                                  DomainRepository domainRepository, NocRepository nocRepository, NicRepository nicRepository, DiagnosticRepository diagnosticRepository, JavaMailSender javaMailSender, WebMessageRepository webMessageRepository, AlarmaRepository alarmaRepository) {
        this.caaRepository = caaRepository;
        this.dxRepository = dxRepository;
        this.framinghamRepository = framinghamRepository;
        this.userRepository = userRepository;
        this.homeRepository = homeRepository;
        this.domainRepository = domainRepository;
        this.nocRepository = nocRepository;
        this.nicRepository = nicRepository;
        this.diagnosticRepository = diagnosticRepository;
        this.javaMailSender = javaMailSender;
        this.webMessageRepository = webMessageRepository;
        this.alarmaRepository = alarmaRepository;
    }

    @Override
    public Framingham postFramingham(FraminghamDto framinghamDto) {
        return framinghamRepository.save(FraminghamBuilder.build(framinghamDto));
    }

    @Override
    public Framingham getFraminghamByDocumentNumber(String documentNumber) {
        return framinghamRepository.findByDocumentNumber(documentNumber);
    }

    @Override
    public List<String> getDomains() {

        List<String> domainNames = new ArrayList<>();
        domainRepository.findAll().forEach(domain -> domainNames.add(domain.getDomainName()));

        return domainNames;
    }

    @Override
    public Dx getDx(String documentNumber) {
        return (dxRepository.findByDocumentNumber(documentNumber) != null)
                ? dxRepository.findByDocumentNumber(documentNumber)
                : new Dx();
    }

    @Override
    public Dx saveDx(Dx dx) {
        return dxRepository.save(dx);
    }

    @Override
    public Domain saveDomain(Domain domain) {
        return domainRepository.save(domain);
    }

    @Override
    public NOC saveNoc(NOC noc) {
        return nocRepository.save(noc);
    }

    @Override
    public List<NOC> getNocsByDiagnosticId(String diagnosticId) {
        return nocRepository.findByDiagnosticId(diagnosticId);
    }

    @Override
    public NIC saveNic(NIC nic) {
        return nicRepository.save(nic);
    }

    @Override
    public List<NIC> getNicsByDiagnosticId(String diagnosticId) {
        return nicRepository.findByDiagnosticId(diagnosticId);
    }

    @Override
    public CAA postCaa(CAADto caaDto) {
        return caaRepository.save(CAABuilder.build(caaDto));
    }

    @Override
    public CAA getCaaByDocumentNumber(String documentNumber) {
        return caaRepository.findByDocumentNumber(documentNumber);
    }

    @Override
    public Home getHome(String documentNumber) {
        Home home = new Home();
        Framingham resultadoRcv = getFraminghamByDocumentNumber(documentNumber);
        CAA resultadoCaa = getCaaByDocumentNumber(documentNumber);
        Logica logic = new Logica();
        home.setColor(logic.getColor(resultadoCaa.getResult(), resultadoRcv.getResult()));
        home.setRecomendacionesList(logic.getRecomendaciones(resultadoCaa, resultadoRcv));
        return home;
    }

    @Override
    public List<Diagnostic> getDiagnosticsByDomainName(String domainName) {
        return diagnosticRepository.findAllByDomainName(domainName);
    }

    @Override
    public Diagnostic saveDiagnostic(Diagnostic diagnostic) {
        return diagnosticRepository.save(diagnostic);
    }

    @Override
    public User registerUser(UserDTO userDTO) {
        return userRepository.save(UserBuilder.build(userDTO));
    }

    @Override
    public FirstLogin logInUser(String documentNumber, String password) {
        FirstLogin firstLogin = new FirstLogin();
        Utils util = new Utils(framinghamRepository);
        try {
            User user = userRepository.findByDocumentNumber(documentNumber);
            firstLogin.setFirstLogin(util.validateLogin(documentNumber));
            firstLogin.setLoginStatus(user.getPassword().equals(password));
            return firstLogin;
        } catch (Exception e) {
            firstLogin.setLoginStatus(false);
            return firstLogin;
        }
    }

    @Override
    public List<UserToDx> getUsers() {

        List<User> users = userRepository.findAll();
        List<UserToDx> usersToDx = new ArrayList<>();

        users.forEach(user -> usersToDx.add(UserToDxBuilder.build(user)));
        return usersToDx;
    }

    @Override
    public User getUser(String documentNumber) {
        return userRepository.findByDocumentNumber(documentNumber);
    }

    @Override
    public List<Alarma> getAlarmaWeb(String documentNumber) {
        return alarmaRepository.findAllByDocumentNumber(documentNumber);
    }

    @Override
    public List<WebMessage> getWebMessage(String documentNumber) {
        return webMessageRepository.findAllByDocumentNumber(documentNumber);
    }

    @Override
    public String sendAlarm(AlarmDto dto) {

        emailSender(dto);

        alarmaRepository.save(Alarma.builder()
                .documentNumber(dto.getDocumentNumber())
                .alarmDate(new Date())
                .preguntaList(dto.getPreguntaList())
                .build());

        return "Envío exitoso.";
    }

    private void emailSender(AlarmDto dto) {

        SimpleMailMessage msg = new SimpleMailMessage();

        try {
            msg.setTo(setTo);
            msg.setSubject("¡Alarma!");
            msg.setText("Hay una nueva alarma enviada por: " + userRepository.findByDocumentNumber(dto.getDocumentNumber()).getUserName()
                    + " " + userRepository.findByDocumentNumber(dto.getDocumentNumber()).getLastName() + "\n"
                    + "¡Apresúrate a revisarla!");

            javaMailSender.send(msg);

        } catch (Exception e) {

            System.out.println("Error: " + e.getMessage());
        }
    }

    @Override
    public String sendWebMessage(WebMessageDto dto) {

        webMessageRepository.save(WebMessage.builder().documentNumber(dto.getDocumentNumber()).from(dto.getFrom()).date(new Date())
                .tituloEmail(dto.getTituloEmail()).cuerpoEmail(dto.getCuerpoEmail()).build());

        return "Envío exitoso";
    }
}