package unac.selfcare.selfcareapp.services;

import org.springframework.stereotype.Service;
import unac.selfcare.selfcareapp.email.WebMessage;
import unac.selfcare.selfcareapp.model.Alarma;
import unac.selfcare.selfcareapp.model.dtos.AlarmDto;
import unac.selfcare.selfcareapp.model.dtos.WebMessageDto;

import java.util.List;

@Service
public interface CommunicationService {
    List<Alarma> getAlarmaWeb(String documentNumber);
    List<WebMessage> getWebMessage(String documentNumber);
    String sendAlarm(AlarmDto dto);
    String sendWebMessage(WebMessageDto message);
}