package unac.selfcare.selfcareapp.model.builders;

import unac.selfcare.selfcareapp.model.CAA;
import unac.selfcare.selfcareapp.model.dtos.CAADto;
import unac.selfcare.selfcareapp.services.impl.Logica;

public class CAABuilder {

    public static CAA build(CAADto caaDto) {
        Logica logic = new Logica();
        CAA caa = new CAA();

        caa.setDocumentNumber(caaDto.getDocumentNumber());
        caa.setDocumentNumber(caaDto.getDocumentNumber());
        caa.setRespuestas(caaDto.getRespuestas());
        caa.setResult(logic.calcularCaa(caaDto.getRespuestas()));
        return caa;
    }
}
