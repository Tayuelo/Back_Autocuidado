package unac.selfcare.selfcareapp.model.builders;

import unac.selfcare.selfcareapp.model.Paciente;
import unac.selfcare.selfcareapp.model.dtos.PacienteDTO;

public class PacienteBuilder {

    public static Paciente build(PacienteDTO pacienteDTO) {

        Paciente paciente = new Paciente();

        paciente.setDocumentId(pacienteDTO.getDocumentId());
        paciente.setName(pacienteDTO.getName());
        paciente.setLastName(pacienteDTO.getLastName());
        paciente.setPassword(pacienteDTO.getPassword());

        return paciente;
    }
}
