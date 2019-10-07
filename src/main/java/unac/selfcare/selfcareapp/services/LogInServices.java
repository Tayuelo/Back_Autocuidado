package unac.selfcare.selfcareapp.services;

import org.springframework.stereotype.Service;
import unac.selfcare.selfcareapp.model.Paciente;
import unac.selfcare.selfcareapp.model.dtos.PacienteDTO;

import java.util.List;

@Service
public interface LogInServices {

    Paciente registerUser(PacienteDTO pacienteDTO);
    Boolean logInUser(String document, String password);
    List<Paciente> getPacientes();
    Paciente getPaciente(String documentId);
}
