package unac.selfcare.selfcareapp.services.impl;

import lombok.Data;
import lombok.NoArgsConstructor;
import unac.selfcare.selfcareapp.model.dtos.FraminghamDto;

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

    public String calcularCaa(
            int a1,
            int a2,
            int a3,
            int a4,
            int a5,
            int a6,
            int a7,
            int a8,
            int a9,
            int a10,
            int a11,
            int a12,
            int a13,
            int a14,
            int a15,
            int a16,
            int a17
    ) {
        int sum = 0;

        sum = a1 + a2 + a3 + a4 + a5 + a6 + a7 + a8 + a9 + a10 + a11 + a12 + a13 + a14 + a15 + a16 + a17;

        if (sum >= 17 && sum <= 28)
            return BAJA_CAA;
        if (sum >= 29 && sum <= 56)
            return MEDIA_CAA;
        if (sum >= 57 && sum <= 85)
            return ALTA_CAA;
        return "El resultado no es válido";
    }

    public String calcularRcv(FraminghamDto dto) {

        if ("M".equals(dto.getUserGender())) {
            int puntajeEdad = getPuntajeEdadM(dto.getUserAge());
            int puntajeColesterol = getPuntajeColesterolM(dto.getRespuestas().get(0), dto.getUserAge());
            int puntajeFumador = getPuntajeFumaM(dto.getRespuestas().get(1), dto.getUserAge());
            int puntajeHDL = getPuntajeHDL(dto.getRespuestas().get(2));
            int puntajePASistolica = getPASistolicaM(dto.getRespuestas().get(3), dto.getUserAge());
            int result = puntajeEdad + puntajeColesterol + puntajeFumador + puntajeHDL + puntajePASistolica;
            if (result < 10)
                return LEVE_RCV;
            if (result <= 20)
                return MODERADO_RCV;
            return SEVERO_RCV;
        }
        if ("F".equals(dto.getUserGender())) {
            int puntajeEdad = getPuntajeEdadF(dto.getUserAge());
            int puntajeColesterol = getPuntajeColesterolF(dto.getRespuestas().get(0), dto.getUserAge());
            int puntajeFumador = getPuntajeFumaF(dto.getRespuestas().get(1), dto.getUserAge());
            int puntajeHDL = getPuntajeHDL(dto.getRespuestas().get(2));
            int puntajePASistolica = getPASistolicaF(dto.getRespuestas().get(3), dto.getUserAge());
            int result = puntajeEdad + puntajeColesterol + puntajeFumador + puntajeHDL + puntajePASistolica;
            if (result < 10)
                return LEVE_RCV;
            if (result <= 20)
                return MODERADO_RCV;
            return SEVERO_RCV;
        }
        return "Datos inválidos";
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

    private int getPuntajeColesterolM(String s, int age) {
        int puntajeColesterol = 0;

        if (s.equals("b") && age >= 20 && age <= 39) {
            puntajeColesterol = 4;
        }
        if (s.equals("b") && age >= 40 && age <= 49) {
            puntajeColesterol = 3;
        }
        if (s.equals("b") && age >= 50 && age <= 59) {
            puntajeColesterol = 2;
        }
        if (s.equals("b") && age >= 60 && age <= 69) {
            puntajeColesterol = 1;
        }

        if (s.equals("c") && age >= 20 && age <= 39) {
            puntajeColesterol = 7;
        }
        if (s.equals("c") && age >= 40 && age <= 49) {
            puntajeColesterol = 5;
        }
        if (s.equals("c") && age >= 50 && age <= 59) {
            puntajeColesterol = 3;
        }
        if (s.equals("c") && age >= 60 && age <= 69) {
            puntajeColesterol = 1;
        }

        if (s.equals("d") && age >= 20 && age <= 39) {
            puntajeColesterol = 9;
        }
        if (s.equals("d") && age >= 40 && age <= 49) {
            puntajeColesterol = 6;
        }
        if (s.equals("d") && age >= 50 && age <= 59) {
            puntajeColesterol = 4;
        }
        if (s.equals("d") && age >= 60 && age <= 69) {
            puntajeColesterol = 2;
        }
        if (s.equals("d") && age >= 70 && age <= 79) {
            puntajeColesterol = 1;
        }

        if (s.equals("e") && age >= 20 && age <= 39) {
            puntajeColesterol = 11;
        }
        if (s.equals("e") && age >= 40 && age <= 49) {
            puntajeColesterol = 8;
        }
        if (s.equals("e") && age >= 50 && age <= 59) {
            puntajeColesterol = 5;
        }
        if (s.equals("e") && age >= 60 && age <= 69) {
            puntajeColesterol = 3;
        }
        if (s.equals("e") && age >= 70 && age <= 79) {
            puntajeColesterol = 1;
        }
        return puntajeColesterol;
    }

    private int getPuntajeColesterolF(String s, int age) {
        int puntajeColesterol = 0;

        if (s.equals("b") && age >= 20 && age <= 39) {
            puntajeColesterol = 4;
        }
        if (s.equals("b") && age >= 40 && age <= 49) {
            puntajeColesterol = 3;
        }
        if (s.equals("b") && age >= 50 && age <= 59) {
            puntajeColesterol = 2;
        }
        if (s.equals("b") && age >= 60 && age <= 69) {
            puntajeColesterol = 1;
        }
        if (s.equals("b") && age >= 70 && age <= 79) {
            puntajeColesterol = 1;
        }

        if (s.equals("c") && age >= 20 && age <= 39) {
            puntajeColesterol = 8;
        }
        if (s.equals("c") && age >= 40 && age <= 49) {
            puntajeColesterol = 6;
        }
        if (s.equals("c") && age >= 50 && age <= 59) {
            puntajeColesterol = 4;
        }
        if (s.equals("c") && age >= 60 && age <= 69) {
            puntajeColesterol = 2;
        }
        if (s.equals("c") && age >= 70 && age <= 79) {
            puntajeColesterol = 1;
        }

        if (s.equals("d") && age >= 20 && age <= 39) {
            puntajeColesterol = 11;
        }
        if (s.equals("d") && age >= 40 && age <= 49) {
            puntajeColesterol = 8;
        }
        if (s.equals("d") && age >= 50 && age <= 59) {
            puntajeColesterol = 5;
        }
        if (s.equals("d") && age >= 60 && age <= 69) {
            puntajeColesterol = 3;
        }
        if (s.equals("d") && age >= 70 && age <= 79) {
            puntajeColesterol = 2;
        }

        if (s.equals("e") && age >= 20 && age <= 39) {
            puntajeColesterol = 13;
        }
        if (s.equals("e") && age >= 40 && age <= 49) {
            puntajeColesterol = 10;
        }
        if (s.equals("e") && age >= 50 && age <= 59) {
            puntajeColesterol = 7;
        }
        if (s.equals("e") && age >= 60 && age <= 69) {
            puntajeColesterol = 4;
        }
        if (s.equals("e") && age >= 70 && age <= 79) {
            puntajeColesterol = 2;
        }
        return puntajeColesterol;
    }

    private int getPuntajeEdadM(int age) {

        int puntajeEdad = 0;

        if (age >= 20 && age <= 34) {
            puntajeEdad = -9;
        }
        if (age >= 35 && age <= 39) {
            puntajeEdad = -4;
        }
        if (age >= 40 && age <= 44) {
            puntajeEdad = 0;
        }
        if (age >= 45 && age <= 49) {
            puntajeEdad = 3;
        }
        if (age >= 50 && age <= 54) {
            puntajeEdad = 6;
        }
        if (age >= 55 && age <= 59) {
            puntajeEdad = 8;
        }
        if (age >= 60 && age <= 64) {
            puntajeEdad = 10;
        }
        if (age >= 65 && age <= 69) {
            puntajeEdad = 11;
        }
        if (age >= 70 && age <= 74) {
            puntajeEdad = 12;
        }
        if (age >= 75 && age <= 79) {
            puntajeEdad = 13;
        }

        return puntajeEdad;
    }

    private int getPuntajeEdadF(int age) {

        int puntajeEdad = 0;

        if (age >= 20 && age <= 34) {
            puntajeEdad = -7;
        }
        if (age >= 35 && age <= 39) {
            puntajeEdad = -3;
        }
        if (age >= 40 && age <= 44) {
            puntajeEdad = 0;
        }
        if (age >= 45 && age <= 49) {
            puntajeEdad = 3;
        }
        if (age >= 50 && age <= 54) {
            puntajeEdad = 6;
        }
        if (age >= 55 && age <= 59) {
            puntajeEdad = 8;
        }
        if (age >= 60 && age <= 64) {
            puntajeEdad = 10;
        }
        if (age >= 65 && age <= 69) {
            puntajeEdad = 12;
        }
        if (age >= 70 && age <= 74) {
            puntajeEdad = 14;
        }
        if (age >= 75 && age <= 79) {
            puntajeEdad = 16;
        }

        return puntajeEdad;
    }

    private int getPuntajeFumaM(String s, int age) {
        int puntajeFuma = 0;

        if (s.equals("a") && age >= 20 && age <= 39) {
            puntajeFuma = 8;
        }
        if (s.equals("a") && age >= 40 && age <= 49) {
            puntajeFuma = 5;
        }
        if (s.equals("a") && age >= 50 && age <= 59) {
            puntajeFuma = 3;
        }
        if (s.equals("a") && age >= 60 && age <= 69) {
            puntajeFuma = 1;
        }
        if (s.equals("a") && age >= 70 && age <= 79) {
            puntajeFuma = 1;
        }
        return puntajeFuma;
    }

    private int getPuntajeFumaF(String s, int age) {
        int puntajeFuma = 0;

        if (s.equals("a") && age >= 20 && age <= 39) {
            puntajeFuma = 9;
        }
        if (s.equals("a") && age >= 40 && age <= 49) {
            puntajeFuma = 7;
        }
        if (s.equals("a") && age >= 50 && age <= 59) {
            puntajeFuma = 4;
        }
        if (s.equals("a") && age >= 60 && age <= 69) {
            puntajeFuma = 2;
        }
        if (s.equals("a") && age >= 70 && age <= 79) {
            puntajeFuma = 1;
        }
        return puntajeFuma;
    }

    private int getPuntajeHDL(String s) {
        int puntajeHDL = 0;

        if (s.equals("a")) {
            puntajeHDL = 1;
        }
        if (s.equals("b")) {
            puntajeHDL = 0;
        }
        if (s.equals("c")) {
            puntajeHDL = 1;
        }
        if (s.equals("d")) {
            puntajeHDL = 2;
        }
        return puntajeHDL;
    }

    private int getPASistolicaM(String s, int userAge) {

        int puntajePASistolica = 0;

        if (s.equals("nc")) {
            puntajePASistolica = 1;
        }
        if (s.equals("nd")) {
            puntajePASistolica = 1;
        }
        if (s.equals("ne")) {
            puntajePASistolica = 2;
        }
        if (s.equals("tb")) {
            puntajePASistolica = 1;
        }
        if (s.equals("tc")) {
            puntajePASistolica = 2;
        }
        if (s.equals("td")) {
            puntajePASistolica = 2;
        }
        if (s.equals("te")) {
            puntajePASistolica = 3;
        }
        return puntajePASistolica;
    }

    private int getPASistolicaF(String s, int userAge) {

        int puntajePASistolica = 0;

        if (s.equals("nb")) {
            puntajePASistolica = 1;
        }
        if (s.equals("nc")) {
            puntajePASistolica = 2;
        }
        if (s.equals("nd")) {
            puntajePASistolica = 3;
        }
        if (s.equals("ne")) {
            puntajePASistolica = 4;
        }
        if (s.equals("tb")) {
            puntajePASistolica = 3;
        }
        if (s.equals("tc")) {
            puntajePASistolica = 4;
        }
        if (s.equals("td")) {
            puntajePASistolica = 5;
        }
        if (s.equals("te")) {
            puntajePASistolica = 6;
        }
        return puntajePASistolica;
    }
}
