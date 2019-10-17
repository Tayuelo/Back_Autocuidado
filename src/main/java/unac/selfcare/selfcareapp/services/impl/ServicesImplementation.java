package unac.selfcare.selfcareapp.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unac.selfcare.selfcareapp.model.*;
import unac.selfcare.selfcareapp.model.builders.CAABuilder;
import unac.selfcare.selfcareapp.model.builders.FraminghamBuilder;
import unac.selfcare.selfcareapp.model.builders.UserBuilder;
import unac.selfcare.selfcareapp.model.builders.UserToDxBuilder;
import unac.selfcare.selfcareapp.model.dtos.*;
import unac.selfcare.selfcareapp.model.Home;
import unac.selfcare.selfcareapp.model.web.Diagnostic;
import unac.selfcare.selfcareapp.model.web.Domain;
import unac.selfcare.selfcareapp.model.web.NIC;
import unac.selfcare.selfcareapp.model.web.NOC;
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
import java.util.List;

@Service
public class ServicesImplementation implements SelfcareServices, LogInServices {

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

    public ServicesImplementation(CAARepository caaRepository, DXRepository dxRepository,
                                  FraminghamRepository framinghamRepository, UserRepository userRepository, HomeRepository homeRepository,
                                  DomainRepository domainRepository, NocRepository nocRepository, NicRepository nicRepository, DiagnosticRepository diagnosticRepository) {
        this.caaRepository = caaRepository;
        this.dxRepository = dxRepository;
        this.framinghamRepository = framinghamRepository;
        this.userRepository = userRepository;
        this.homeRepository = homeRepository;
        this.domainRepository = domainRepository;
        this.nocRepository = nocRepository;
        this.nicRepository = nicRepository;
        this.diagnosticRepository = diagnosticRepository;
    }

    // Servicios para el Framingham
    @Override
    public Framingham postFramingham(FraminghamDto framinghamDto) {
        return framinghamRepository.save(FraminghamBuilder.build(framinghamDto));
    }

    @Override
    public Framingham getFraminghamByDocumentNumber(String documentNumber) {
        return framinghamRepository.findByDocumentNumber(documentNumber);
    }

    @Override
    public List<Domain> getDomains() {
        return domainRepository.findAll();
    }

    @Override
    public Dx getDx(String documentNumber) {
        Dx dx = dxRepository.findByDocumentNumber("0000000000");
        dx.setDocumentNumber(documentNumber);
        return dx;
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
        Logica logic = new Logica();
        String resultadoRcv = getFraminghamByDocumentNumber(documentNumber).getResult();
        String resultadoCaa = getCaaByDocumentNumber(documentNumber).getResult();

        String color = logic.getColor(resultadoCaa, resultadoRcv);
        switch (color) {
            case "AMARILLO":
                return homeRepository.findByTextsByColor("1");
            case "NARANJA":
                return homeRepository.findByTextsByColor("2");
            case "ROJO":
                return homeRepository.findByTextsByColor("3");
            case "VERDE":
                return homeRepository.findByTextsByColor("4");
            default:
                break;
        }
        return homeRepository.findByTextsByColor("0");
    }

    @Override
    public List<Diagnostic> getDiagnosticsByDomainId(String domainId) {
        return diagnosticRepository.findAllByDomainId(domainId);
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
}