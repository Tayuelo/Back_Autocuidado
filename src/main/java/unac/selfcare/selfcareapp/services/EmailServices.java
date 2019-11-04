package unac.selfcare.selfcareapp.services;

import org.springframework.stereotype.Service;
import unac.selfcare.selfcareapp.model.dtos.EmailDTO;

@Service
public interface EmailServices {
    void sendEmail(EmailDTO dto);
}