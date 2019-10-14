package unac.selfcare.selfcareapp.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unac.selfcare.selfcareapp.model.*;
import unac.selfcare.selfcareapp.model.builders.CAABuilder;
import unac.selfcare.selfcareapp.model.builders.FraminghamBuilder;
import unac.selfcare.selfcareapp.model.builders.UserBuilder;
import unac.selfcare.selfcareapp.model.builders.UserToDxBuilder;
import unac.selfcare.selfcareapp.model.dtos.CAADto;
import unac.selfcare.selfcareapp.model.dtos.FraminghamDto;
import unac.selfcare.selfcareapp.model.dtos.UserDTO;
import unac.selfcare.selfcareapp.model.dtos.UserToDx;
import unac.selfcare.selfcareapp.services.LogInServices;
import unac.selfcare.selfcareapp.services.SelfcareServices;
import unac.selfcare.selfcareapp.services.repositories.*;

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

    public ServicesImplementation(CAARepository caaRepository, DXRepository dxRepository,
                                  FraminghamRepository framinghamRepository, UserRepository userRepository, HomeRepository homeRepository) {
        this.caaRepository = caaRepository;
        this.dxRepository = dxRepository;
        this.framinghamRepository = framinghamRepository;
        this.userRepository = userRepository;
        this.homeRepository = homeRepository;
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

    // Servicios para el CAA
    @Override
    public CAA postCaa(CAADto caaDto) {
        return caaRepository.save(CAABuilder.build(caaDto));
    }

    @Override
    public CAA getCaaByDocumentNumber(String documentNumber) {
        return caaRepository.findByDocumentNumber(documentNumber);
    }

    // Servicios para el Dx
    /*
    @Override
    public Dx getDx(String documentNumber) {
        Logica logic = new Logica();

        String resultadoCaa = logic.calcularCaa(getCaaByDocumentNumber(documentNumber).getRespuestas());
        String resultadoRcv = logic.calcularRcv(getFraminghamByDocumentNumber(documentNumber).getRespuestas());
        String dxFinal = logic.getDx(resultadoCaa, resultadoRcv);
        Dx dx = new Dx(documentNumber, resultadoCaa, resultadoRcv, dxFinal);
        dxRepository.save(dx);
        return dx;
    }
     */

    @Override
    public List<Domain> getDomainById(String domainId) {
        return null;
    }

    @Override
    public List<Diagnostics> getDiagnosticsById(String domainId) {
        return null;
    }

    @Override
    public List<Diagnostics> saveDiagnostics(String domainId) {
        return null;
    }

    @Override
    public List<Domain> saveDomains(List<Domain> domainList) {
        return null;
    }

    @Override
    public Home getHome(String documentNumber) {
        Logica logic = new Logica();
        String resultadoCaa = getCaaByDocumentNumber(documentNumber).getResult();
        String resultadoRcv = getFraminghamByDocumentNumber(documentNumber).getResult();

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
    public User registerUser(UserDTO userDTO) {

        return userRepository.save(UserBuilder.build(userDTO));
    }

    @Override
    public Boolean logInUser(String documentNumber, String password) {
        try {
            User user = userRepository.findByDocumentNumber(documentNumber);
            return user.getPassword().equals(password);
        } catch (Exception e) {
            return false;
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