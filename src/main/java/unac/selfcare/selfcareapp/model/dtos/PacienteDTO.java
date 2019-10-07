package unac.selfcare.selfcareapp.model.dtos;

import lombok.Data;

@Data
public class PacienteDTO {

    private String documentId;
    private String name;
    private String lastName;
    private String password;
}
