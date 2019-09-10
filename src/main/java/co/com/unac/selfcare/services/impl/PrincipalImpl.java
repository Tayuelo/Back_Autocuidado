package co.com.unac.selfcare.services.impl;

import co.com.unac.selfcare.model.Alert;
import co.com.unac.selfcare.model.Dx;
import co.com.unac.selfcare.model.Recomendaciones;
import co.com.unac.selfcare.services.interfaces.DxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PrincipalImpl implements DxService {

    @Override
    public Alert postDx(Dx dx) {
        return alertConverter(dx);
    }

    private Alert alertConverter(Dx dx) {
        int r1 = dx.getRespuesta1();
        int r2 = dx.getRespuesta2();
        int r3 = dx.getRespuesta3();
        int r4 = dx.getRespuesta4();
        int r5 = dx.getRespuesta5();

        Recomendaciones recomendaciones = new Recomendaciones("","","","","");

        Alert alert = new Alert("AA", 5, recomendaciones);

        return alert;
    }
}
