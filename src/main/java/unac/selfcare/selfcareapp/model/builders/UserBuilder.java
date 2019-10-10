package unac.selfcare.selfcareapp.model.builders;

import unac.selfcare.selfcareapp.model.User;
import unac.selfcare.selfcareapp.model.dtos.UserDTO;

public class UserBuilder {

    public static User build(UserDTO userDTO) {

        User user = new User();

        user.setDocumentId(userDTO.getDocumentId());
        user.setName(userDTO.getName());
        user.setLastName(userDTO.getLastName());
        user.setPassword(userDTO.getPassword());
        user.setRol(userDTO.getRol());

        return user;
    }
}
