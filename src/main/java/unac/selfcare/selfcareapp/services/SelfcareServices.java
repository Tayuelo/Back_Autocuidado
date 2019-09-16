package unac.selfcare.selfcareapp.services;

import org.springframework.stereotype.Service;
import unac.selfcare.selfcareapp.model.Paciente;

import java.util.List;

@Service
public interface SelfcareServices {

    List<Paciente> getPacientes();

    Paciente postPaciente(Paciente paciente);
}
