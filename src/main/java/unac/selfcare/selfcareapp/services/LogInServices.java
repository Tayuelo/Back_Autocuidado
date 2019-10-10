package unac.selfcare.selfcareapp.services;

import org.springframework.stereotype.Service;
import unac.selfcare.selfcareapp.model.User;
import unac.selfcare.selfcareapp.model.dtos.UserDTO;

import java.util.List;

@Service
public interface LogInServices {

    User registerUser(UserDTO userDTO);
    Boolean logInUser(String document, String password);
    List<User> getUsers();
    User getUser(String documentId);
}
