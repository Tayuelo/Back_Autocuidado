package unac.selfcare.selfcareapp.services.impl;

import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.ArrayList;


@Data
@NoArgsConstructor
public
class Logica {

    private static final String BAJA_CAA = "BAJA";
    private static final String MEDIA_CAA = "MEDIA";
    private static final String ALTA_CAA = "ALTA";
    private static final String LEVE_RCV = "LEVE";
    private static final String MODERADO_RCV = "MODERADO";
    private static final String SEVERO_RCV = "SEVERO";

    private static final String AMARILLO = "AMARILLO";
    private static final String NARANJA = "NARANJA";
    private static final String ROJO = "ROJO";
    private static final String VERDE = "VERDE";

    ArrayList<Integer> respuestasCaa;
    ArrayList<Integer> respuestasRcv;

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

    String getColor(String resultadoCaa, String resultadoRcv) {

        if (resultadoCaa.equals(BAJA_CAA) && resultadoRcv.equals(LEVE_RCV)) {
            return AMARILLO;
        } else if (resultadoCaa.equals(BAJA_CAA) && resultadoRcv.equals(MODERADO_RCV)) {
            return NARANJA;
        } else if (resultadoCaa.equals(BAJA_CAA) && resultadoRcv.equals(SEVERO_RCV)) {
            return ROJO;
        } else if (resultadoCaa.equals(MEDIA_CAA) && resultadoRcv.equals(LEVE_RCV)) {
            return VERDE;
        } else if (resultadoCaa.equals(MEDIA_CAA) && resultadoRcv.equals(MODERADO_RCV)) {
            return NARANJA;
        } else if (resultadoCaa.equals(MEDIA_CAA) && resultadoRcv.equals(SEVERO_RCV)) {
            return ROJO;
        } else if (resultadoCaa.equals(ALTA_CAA) && resultadoRcv.equals(LEVE_RCV)) {
            return VERDE;
        } else if (resultadoCaa.equals(ALTA_CAA) && resultadoRcv.equals(MODERADO_RCV)) {
            return AMARILLO;
        } else if (resultadoCaa.equals(ALTA_CAA) && resultadoRcv.equals(SEVERO_RCV)) {
            return NARANJA;
        }
        return "Resultados inválidos.";
    }
}
