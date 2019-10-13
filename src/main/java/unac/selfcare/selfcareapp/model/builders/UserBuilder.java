package unac.selfcare.selfcareapp.model.builders;

import unac.selfcare.selfcareapp.model.User;
import unac.selfcare.selfcareapp.model.dtos.UserDTO;

public class UserBuilder {

    public static User build(UserDTO userDTO) {

        User user = new User();

        user.setDocumentNumber(userDTO.getDocumentNumber());
        user.setUserName(userDTO.getUserName());
        user.setLastName(userDTO.getLastName());
        user.setPassword(userDTO.getPassword());
        user.setUserRol(userDTO.getUserRol());

        return user;
    }
}
