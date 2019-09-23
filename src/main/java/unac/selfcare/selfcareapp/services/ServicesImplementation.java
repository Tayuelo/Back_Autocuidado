package unac.selfcare.selfcareapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unac.selfcare.selfcareapp.model.CAA;
import unac.selfcare.selfcareapp.model.Paciente;

import java.util.List;

@Service
public class ServicesImplementation implements SelfcareServices {

    @Autowired
    private SelfcareRepository repository;
    @Autowired
    private CAARepository caaRepository;

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
}
