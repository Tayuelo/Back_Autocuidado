package unac.selfcare.selfcareapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unac.selfcare.selfcareapp.model.CAA;
import unac.selfcare.selfcareapp.model.Dx;
import unac.selfcare.selfcareapp.model.Paciente;
import unac.selfcare.selfcareapp.model.Framingham;

import java.util.List;

@Service
public class ServicesImplementation implements SelfcareServices {

    @Autowired
    private SelfcareRepository repository;
    @Autowired
    private CAARepository caaRepository;
    @Autowired
    private DXRepository dxRepository;
    @Autowired
    private RCVRepository rcvRepository;
    @Autowired
    private FraminghamRepository framinghamRepository;

    private Lógica logic;

    public ServicesImplementation(SelfcareRepository repository, CAARepository caaRepository, DXRepository dxRepository, RCVRepository rcvRepository, FraminghamRepository framinghamRepository) {
        this.repository = repository;
        this.caaRepository = caaRepository;
        this.dxRepository = dxRepository;
        this.rcvRepository = rcvRepository;
        this.framinghamRepository = framinghamRepository;
    }

    @Override
    public List<Paciente> getPacientes() {

        return repository.findAll();
    }

    @Override
    public Paciente postPaciente(Paciente paciente) {
        return repository.save(paciente);
    }

    @Override
    public CAA postCaa(CAA caa) {
        return caaRepository.save(caa);
    }

    @Override
    public Framingham postFramingham(Framingham framingham) {
        return framinghamRepository.save(framingham);
    }

    @Override
    public Framingham getFraminghamById(String userId) {
        return framinghamRepository.findByUserId(userId);
    }

    public CAA getCaaById(String userId) {
        return caaRepository.findByUserId(userId);
    }

    @Override
    public Dx getDx(String id) {
        return null;
    }

    @Override
    public List<CAA> getCaa() {
        return caaRepository.findAll();
    }
}
