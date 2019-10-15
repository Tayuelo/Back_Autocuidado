package unac.selfcare.selfcareapp.model.builders;

import unac.selfcare.selfcareapp.model.Framingham;
import unac.selfcare.selfcareapp.model.dtos.FraminghamDto;
import unac.selfcare.selfcareapp.services.impl.Logica;

public class FraminghamBuilder {

    public static Framingham build(FraminghamDto framinghamDto) {
        Logica logic = new Logica();
        Framingham framingham = new Framingham();

        framingham.setDocumentNumber(framinghamDto.getDocumentNumber());
        framingham.setUserGender(framinghamDto.getUserGender());
        framingham.setUserAge(framinghamDto.getUserAge());
        framingham.setRespuestas(framinghamDto.getRespuestas());
        framingham.setResult(logic.calcularRcv(framinghamDto));
        return framingham;
    }
}
