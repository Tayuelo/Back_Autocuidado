package unac.selfcare.selfcareapp.model.builders;


import unac.selfcare.selfcareapp.model.User;
import unac.selfcare.selfcareapp.model.dtos.UserToDx;

public class UserToDxBuilder {

    public static UserToDx build(User user) {

        UserToDx userToDx = new UserToDx();

        userToDx.setDocumentId(user.getDocumentId());
        userToDx.setName(user.getName());
        userToDx.setLastName(user.getLastName());
        userToDx.setUserRol(user.getUserRol());

        return userToDx;
    }
}
