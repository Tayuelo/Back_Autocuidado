package unac.selfcare.selfcareapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unac.selfcare.selfcareapp.model.Paciente;

import java.util.List;

@Service
public class ServicesImplementation implements SelfcareServices {

    @Autowired
    private SelfcareRepository repository;

    public ServicesImplementation(SelfcareRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Paciente> getPacientes() {

        return repository.findAll();
    }

    @Override
    public Paciente postPaciente(Paciente paciente) {
        return repository.save(paciente);
    }
}
