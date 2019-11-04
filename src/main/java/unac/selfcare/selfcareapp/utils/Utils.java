package unac.selfcare.selfcareapp.utils;

import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import unac.selfcare.selfcareapp.services.repositories.FraminghamRepository;

@NoArgsConstructor
public class Utils {

    @Autowired
    private FraminghamRepository framinghamRepository;

    public Utils(FraminghamRepository framinghamRepository) {
        this.framinghamRepository = framinghamRepository;
    }

    public Boolean validateLogin(String documentNumber) {
        return !framinghamRepository.existsByDocumentNumber(documentNumber);
    }
}