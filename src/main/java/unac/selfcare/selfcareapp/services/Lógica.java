package unac.selfcare.selfcareapp.services;

import lombok.Data;
import unac.selfcare.selfcareapp.model.CAA;
import unac.selfcare.selfcareapp.model.RCV;

import java.util.ArrayList;


@Data
public class Lógica {

    public final String BAJA_CAA = "BAJA";
    public final String MEDIA_CAA = "MEDIA";
    public final String ALTA_CAA = "ALTA";
    public final String LEVE_RCV = "LEVE";
    public final String MODERADO_RCV = "MODERADO";
    public final String SEVERO_RCV = "SEVERO";

    public final String AMARILLO = "AMARILLO";
    public final String NARANJA = "NARANJA";
    public final String ROJO = "ROJO";
    public final String VERDE = "VERDE";

    ArrayList<Integer> respuestasCaa;
    ArrayList<Integer> respuestasRcv;

    public Lógica(CAA caa) {
        respuestasCaa = caa.getRespuestas();
    }

    public Lógica(RCV rcv) {
        respuestasRcv = rcv.getRespuestas();
    }

    public String calcularCaa(ArrayList<Integer> respuestasCaa) {

        int sum = 0;
        for (int i : respuestasCaa)
            sum += i;

        if (sum >= 17 && sum <= 28)
            return BAJA_CAA;
        if (sum >= 29 && sum <= 56)
            return MEDIA_CAA;
        if (sum >= 57 && sum <= 85)
            return ALTA_CAA;
        return "El resultado no es válido";
    }

    public String calcularRcv(ArrayList<Integer> respuestasRcv) {

        int sum = 0;
        for (int i : respuestasRcv)
            sum += i;

        if (sum < 10)
            return LEVE_RCV;
        if (sum <= 20)
            return MODERADO_RCV;
        return SEVERO_RCV;
    }
}
