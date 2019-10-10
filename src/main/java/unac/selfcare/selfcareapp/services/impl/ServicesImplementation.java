package unac.selfcare.selfcareapp.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unac.selfcare.selfcareapp.model.*;
import unac.selfcare.selfcareapp.model.builders.UserBuilder;
import unac.selfcare.selfcareapp.model.dtos.UserDTO;
import unac.selfcare.selfcareapp.services.LogInServices;
import unac.selfcare.selfcareapp.services.SelfcareServices;
import unac.selfcare.selfcareapp.services.repositories.CAARepository;
import unac.selfcare.selfcareapp.services.repositories.DXRepository;
import unac.selfcare.selfcareapp.services.repositories.FraminghamRepository;
import unac.selfcare.selfcareapp.services.repositories.UserRepository;

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

    public ServicesImplementation(CAARepository caaRepository, DXRepository dxRepository,
                                  FraminghamRepository framinghamRepository, UserRepository userRepository) {
        this.caaRepository = caaRepository;
        this.dxRepository = dxRepository;
        this.framinghamRepository = framinghamRepository;
        this.userRepository = userRepository;

    }

    // Servicios para el Framingham
    @Override
    public Framingham postFramingham(Framingham framingham) {
        return framinghamRepository.save(framingham);
    }

    @Override
    public Framingham getFraminghamByDocumentId(String documentId) {
        return framinghamRepository.findByDocumentId(documentId);
    }

    // Servicios para el CAA
    @Override
    public CAA postCaa(CAA caa) {
        return caaRepository.save(caa);
    }

    @Override
    public CAA getCaaByDocumentId(String documentId) {
        return caaRepository.findByDocumentId(documentId);
    }

    // Servicios para el Dx
    @Override
    public Dx getDx(String documentId) {
        Logica logic = new Logica();

        String resultadoCaa = logic.calcularCaa(getCaaByDocumentId(documentId).getRespuestas());
        String resultadoRcv = logic.calcularRcv(getFraminghamByDocumentId(documentId).getRespuestas());
        String dxFinal = logic.getDx(resultadoCaa, resultadoRcv);
        Dx dx = new Dx(documentId, resultadoCaa, resultadoRcv, dxFinal);
        dxRepository.save(dx);
        return dx;
    }

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
    public User registerUser(UserDTO userDTO) {

        return userRepository.save(UserBuilder.build(userDTO));
    }

    @Override
    public Boolean logInUser(String documentId, String password) {
        try {
            User user = userRepository.findByDocumentId(documentId);
            return user.getPassword().equals(password);
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUser(String documentId) {
        return userRepository.findByDocumentId(documentId);
    }
}