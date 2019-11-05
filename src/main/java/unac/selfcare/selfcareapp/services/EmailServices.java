package unac.selfcare.selfcareapp.services;

import org.springframework.stereotype.Service;
import unac.selfcare.selfcareapp.email.Email;
import unac.selfcare.selfcareapp.model.dtos.EmailDTO;

import java.util.List;
import java.util.Optional;

@Service
public interface EmailServices {
    List<Email> getEmailsWeb(String documentNumber);
    List<Email> getEmailsMobile(String documentNumber);
    void sendEmail(EmailDTO dto);
}