package unac.selfcare.selfcareapp.services;

import org.springframework.stereotype.Service;
import unac.selfcare.selfcareapp.email.Email;
import unac.selfcare.selfcareapp.model.dtos.EmailDTO;

import java.util.List;

@Service
public interface EmailServices {
    List<Email> getEmailsWeb(String documentNumber);
    List<Email> getEmailsMobile(String documentNumber);
    String sendEmail(EmailDTO dto);
    String sendMessageWeb(EmailDTO dto);
}