package unac.selfcare.selfcareapp.services;

import org.springframework.stereotype.Service;
import unac.selfcare.selfcareapp.model.User;
import unac.selfcare.selfcareapp.model.dtos.UserDTO;
import unac.selfcare.selfcareapp.model.dtos.UserToDx;
import unac.selfcare.selfcareapp.utils.FirstLogin;

import java.util.List;

@Service
public interface LogInServices {

    User registerUser(UserDTO userDTO);
    FirstLogin logInUser(String document, String password);
    List<UserToDx> getUsers();
    User getUser(String documentId);
}
