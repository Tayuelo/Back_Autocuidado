package unac.selfcare.selfcareapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unac.selfcare.selfcareapp.model.CAA;
import unac.selfcare.selfcareapp.model.Dx;
import unac.selfcare.selfcareapp.model.Paciente;
import unac.selfcare.selfcareapp.model.RCV;

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

    private Lógica logic;

    public ServicesImplementation(SelfcareRepository repository, CAARepository caaRepository) {
        this.repository = repository;
        this.caaRepository = caaRepository;
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
    public CAA getCaaById(String userId) {
        return null;
    }

    @Override
    public RCV getRcvById(String userId) {
        return null;
    }

    @Override
    public RCV postRcv(RCV rcv) {
        return null;
    }

    @Override
    public Dx getDx(String id) {
        return null;
    }

    @Override
    public List<CAA> getCaa() {
        return null;
    }

    @Override
    public List<RCV> getRcv() {
        return null;
    }
}
