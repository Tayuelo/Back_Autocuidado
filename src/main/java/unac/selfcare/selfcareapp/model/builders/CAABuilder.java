package unac.selfcare.selfcareapp.model.builders;

import unac.selfcare.selfcareapp.model.CAA;
import unac.selfcare.selfcareapp.model.dtos.CAADto;
import unac.selfcare.selfcareapp.services.impl.Logica;

public class CAABuilder {

    public static CAA build(CAADto caaDto) {
        Logica logic = new Logica();
        CAA caa = new CAA();

        caa.setDocumentNumber(caaDto.getDocumentNumber());
        caa.setAnswer1(caaDto.getAnswer1());
        caa.setAnswer2(caaDto.getAnswer2());
        caa.setAnswer3(caaDto.getAnswer3());
        caa.setAnswer4(caaDto.getAnswer4());
        caa.setAnswer5(caaDto.getAnswer5());
        caa.setAnswer6(caaDto.getAnswer6());
        caa.setAnswer7(caaDto.getAnswer7());
        caa.setAnswer8(caaDto.getAnswer8());
        caa.setAnswer9(caaDto.getAnswer9());
        caa.setAnswer10(caaDto.getAnswer10());
        caa.setAnswer11(caaDto.getAnswer11());
        caa.setAnswer12(caaDto.getAnswer12());
        caa.setAnswer13(caaDto.getAnswer13());
        caa.setAnswer14(caaDto.getAnswer14());
        caa.setAnswer15(caaDto.getAnswer15());
        caa.setAnswer16(caaDto.getAnswer16());
        caa.setAnswer17(caaDto.getAnswer17());
        caa.setResult(logic.calcularCaa(
                caaDto.getAnswer1(),
                caaDto.getAnswer2(),
                caaDto.getAnswer3(),
                caaDto.getAnswer4(),
                caaDto.getAnswer5(),
                caaDto.getAnswer6(),
                caaDto.getAnswer7(),
                caaDto.getAnswer8(),
                caaDto.getAnswer9(),
                caaDto.getAnswer10(),
                caaDto.getAnswer11(),
                caaDto.getAnswer12(),
                caaDto.getAnswer13(),
                caaDto.getAnswer14(),
                caaDto.getAnswer15(),
                caaDto.getAnswer16(),
                caaDto.getAnswer17()
        ));
        return caa;
    }
}
