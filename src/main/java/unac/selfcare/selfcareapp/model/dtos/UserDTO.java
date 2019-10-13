package unac.selfcare.selfcareapp.model.dtos;

import lombok.Data;

@Data
public class UserDTO {

    private String documentNumber;
    private String userName;
    private String lastName;
    private String password;
    private String userRol;
}
