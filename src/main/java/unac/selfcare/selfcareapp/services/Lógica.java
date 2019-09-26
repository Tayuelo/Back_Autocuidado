package unac.selfcare.selfcareapp.services;

import lombok.Data;
import unac.selfcare.selfcareapp.model.CAA;
import unac.selfcare.selfcareapp.model.Framingham;

import java.util.ArrayList;


@Data
public class Lógica {

    private final String BAJA_CAA = "BAJA";
    private final String MEDIA_CAA = "MEDIA";
    private final String ALTA_CAA = "ALTA";
    private final String LEVE_RCV = "LEVE";
    private final String MODERADO_RCV = "MODERADO";
    private final String SEVERO_RCV = "SEVERO";

    private final String AMARILLO = "AMARILLO";
    private final String NARANJA = "NARANJA";
    private final String ROJO = "ROJO";
    private final String VERDE = "VERDE";

    ArrayList<Integer> respuestasCaa;
    ArrayList<Integer> respuestasRcv;

    public Lógica(CAA caa) {
        respuestasCaa = caa.getRespuestas();
    }

    public Lógica(Framingham rcv) {
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

    public String getDx(String resultadoCaa, String resultadoRcv) {

        // TODO: Validar ambos resultados con las necesidades del negocio.
        // Si es BAJO - LEVE, enviar el color correspondiente.

        return null;
    }
}
