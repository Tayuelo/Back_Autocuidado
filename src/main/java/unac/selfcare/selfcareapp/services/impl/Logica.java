package unac.selfcare.selfcareapp.services.impl;

import lombok.Data;
import lombok.NoArgsConstructor;
import unac.selfcare.selfcareapp.model.CAA;
import unac.selfcare.selfcareapp.model.Framingham;
import unac.selfcare.selfcareapp.model.dtos.FraminghamDto;

import java.util.ArrayList;
import java.util.List;


@Data
@NoArgsConstructor
public class Logica {

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

    public static List<String> recomendacionesList;

    private static int dieta;
    private static int actividadFisica;
    private static int descanso;
    private static int medicacion;
    private static int autocuidado;
    private static int conocimientoEnfermedad;
    private static int vidaSexual;

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
            int puntajeColesterol = getPuntajeColesterolM(dto.getColesterol(), dto.getUserAge());
            int puntajeFumador = getPuntajeFumaM(dto.getFuma(), dto.getUserAge());
            int puntajeHDL = getPuntajeHDL(dto.getHdl());
            int puntajePASistolica = getPASistolicaM(dto.getPaSistolica(), dto.getUserAge());
            int result = puntajeEdad + puntajeColesterol + puntajeFumador + puntajeHDL + puntajePASistolica;
            if (result < 10)
                return LEVE_RCV;
            if (result <= 20)
                return MODERADO_RCV;
            return SEVERO_RCV;
        }
        if ("F".equals(dto.getUserGender())) {
            int puntajeEdad = getPuntajeEdadF(dto.getUserAge());
            int puntajeColesterol = getPuntajeColesterolF(dto.getColesterol(), dto.getUserAge());
            int puntajeFumador = getPuntajeFumaF(dto.getFuma(), dto.getUserAge());
            int puntajeHDL = getPuntajeHDL(dto.getHdl());
            int puntajePASistolica = getPASistolicaF(dto.getPaSistolica(), dto.getUserAge());
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

    private int getPuntajeFumaM(Boolean s, int age) {
        int puntajeFuma = 0;

        if (s.equals(true) && age >= 20 && age <= 39) {
            puntajeFuma = 8;
        }
        if (s.equals(true) && age >= 40 && age <= 49) {
            puntajeFuma = 5;
        }
        if (s.equals(true) && age >= 50 && age <= 59) {
            puntajeFuma = 3;
        }
        if (s.equals(true) && age >= 60 && age <= 69) {
            puntajeFuma = 1;
        }
        if (s.equals(true) && age >= 70 && age <= 79) {
            puntajeFuma = 1;
        }
        return puntajeFuma;
    }

    private int getPuntajeFumaF(Boolean s, int age) {
        int puntajeFuma = 0;

        if (s.equals(true) && age >= 20 && age <= 39) {
            puntajeFuma = 9;
        }
        if (s.equals(true) && age >= 40 && age <= 49) {
            puntajeFuma = 7;
        }
        if (s.equals(true) && age >= 50 && age <= 59) {
            puntajeFuma = 4;
        }
        if (s.equals(true) && age >= 60 && age <= 69) {
            puntajeFuma = 2;
        }
        if (s.equals(true) && age >= 70 && age <= 79) {
            puntajeFuma = 1;
        }
        return puntajeFuma;
    }

    private int getPuntajeHDL(String s) {
        int puntajeHDL = 0;

        if (s.equals("a")) {
            puntajeHDL = 1;
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

        if (s.equals("b")) {
            puntajePASistolica = 1;
        }
        if (s.equals("c")) {
            puntajePASistolica = 2;
        }
        if (s.equals("d")) {
            puntajePASistolica = 2;
        }
        if (s.equals("e")) {
            puntajePASistolica = 3;
        }
        return puntajePASistolica;
    }

    private int getPASistolicaF(String s, int userAge) {

        int puntajePASistolica = 0;

        if (s.equals("b")) {
            puntajePASistolica = 3;
        }
        if (s.equals("c")) {
            puntajePASistolica = 4;
        }
        if (s.equals("d")) {
            puntajePASistolica = 5;
        }
        if (s.equals("e")) {
            puntajePASistolica = 6;
        }
        return puntajePASistolica;
    }

    static List<String> getRecomendaciones(CAA caa, Framingham rcv) {

        recomendacionesList = new ArrayList<>();

        dieta = caa.getAnswer8() + caa.getAnswer14() + caa.getAnswer16();
        actividadFisica = caa.getAnswer4() + caa.getAnswer12();
        descanso = caa.getAnswer2();
        medicacion = caa.getAnswer6() + caa.getAnswer7() + caa.getAnswer9();
        autocuidado = caa.getAnswer1() + caa.getAnswer3() + caa.getAnswer13() + caa.getAnswer15();
        conocimientoEnfermedad = caa.getAnswer5() + caa.getAnswer10() + caa.getAnswer11();
        vidaSexual = caa.getAnswer17();

        if (dieta < 12) recomendacionesList.add(dietaMsg);

        if (actividadFisica < 8) recomendacionesList.add(actividadFisicaMsg);
        if (descanso < 4) recomendacionesList.add(descansoMsg);

        if (medicacion < 12) recomendacionesList.add(medicacionMsg);
        if (autocuidado < 16) recomendacionesList.add(autocuidadoMsg);
        if (conocimientoEnfermedad < 12) recomendacionesList.add(conocimientoEnfermedadMsg);
        if (vidaSexual < 4) recomendacionesList.add(vidaSexualMsg);

        if (rcv.getColesterol().equals("c")) recomendacionesList.add(colesterolModerado);
        if (rcv.getColesterol().equals("d")) recomendacionesList.add(colesterolAlto);

        if (rcv.getHdl().equals("d")) {
            recomendacionesList.add(hdlAlta);
        } else {
            recomendacionesList.add(hdlNormal);
        }

        if (rcv.getPaSistolica().equals("b") || rcv.getPaSistolica().equals("a")) {
            recomendacionesList.add(paSistNormal);
        } else if (rcv.getPaSistolica().equals("c")) {
            recomendacionesList.add(paSistModerado);
        } else {
            recomendacionesList.add(paSistSevero);
        }

        if (rcv.getFuma().equals(true)) recomendacionesList.add(fumador);

        if (rcv.getUserAge() < 44) {
            recomendacionesList.add(menor44);
        } else {
            recomendacionesList.add(mayor44);
        }

        return recomendacionesList;
    }

    static String dietaMsg = "<b>Dieta</b>\nTe recomendamos aumentar el consumo de verduras, frutas, " +
            "fibra a cinco porciones al día, al igual que una dieta baja en grasas saturadas.";
    static String actividadFisicaMsg = "Recuerda realizar caminatas programadas diariamente," +
            " como mínimo, 30 minutos.";
    static String descansoMsg = "Te recomendamos reforzar el hábito de dormir de 6-8 horas diarias," +
            " para que te puedas sentir más descansado.";
    static String medicacionMsg = "Te recomendamos no cambiar el tratamiento farmacológico por terapias alternativas.";
    static String autocuidadoMsg = "Recuerda invertir tiempo en tu autocuidado," +
            " tal como disfrutar de un masaje, de una buena cena, entre otras actividades.";
    static String conocimientoEnfermedadMsg = "Te recomendamos buscar información y orientación" +
            " sobre el manejo de tu enfermedad.";
    static String vidaSexualMsg = "Es importante saber y entender que a pesar de los cambios fisiológicos" +
            " que enfrenta mi organismo mi enfermedad no me impide que desarrolle manifestaciones de mi vida sexual con mi pareja.";

    // TODO: Refactorizar para base de datos :p

    static String colesterolModerado = "¡Ánimo!  Aun  hay  cosas  podemos mejorar, quiero invitarte a que pongamos en práctica los consejos de hábitos de vida saludable, como lo son: \n" +
            "- Disminuir en la alimentación las grasa saturadas como lo son las de los paquetes, los refritos-\n" +
            "- Aumentar el consumo de grasas saludables, tales como: aceite de oliva, consumo de aguacate, y frutos secos.";

    static String colesterolAlto = "¡TU PUEDES!  Mejorar los  hábitos de vida,  es un trabajo que requiere tiempo y dedicación. Se recomienda:\n" +
            "- Que durante la semana usted debe practicar por lo menos 30 minutos de actividad física durante 5 días a la semana, el ejercicio ayuda a un mejor funcionamiento de nuestro organismo,  y la prevención de enfermedades cardiacas.\n";
    static String hdlNormal = "¡Felicidades! tu nivel de colesterol HDL se encuentre en los rangos normales por lo cual te invitamos a seguir manteniendo hábitos de vida saludable.";
    static String hdlAlta = "¡Tu puedes! Te invito a que cada día podamos mejorar hábitos de vida.\n" +
            "-Podemos agregar a la dieta cotidiana aumento de las frutas y verduras de su agrado, en la preparación usar poca sal  y un aceites saludable como el de oliva, podemos consumir pescado que contengan omega 3, 6 y 9,  aumentar consumo de frutos secos.";
    static String paSistNormal = "¡Felicitaciones! Tienes una presión arterial normal.";
    static String paSistModerado = "¡Te animamos a que tomes nuevos hábitos saludables! \n" +
            "¡Puedes empezar ya!\n" +
            "-Disminuyendo el consumo de sal y grasas en tus comidas\n" +
            "- Durmiendo de 7 a 8 horas diarias.";
    static String paSistSevero = "¡Tú puedes! Tienes una presión arterial muy elevada, te invitamos a que obtengas nuevos hábitos saludables.\n" +
            "-Aumentando la ingesta de alimentos ricos en potasio y calcio como los son los plátanos, bananos, yogurt, leche, entre otros, disminuyendo el consumo de sal, grasas (especialmente las de origen animal), el café, tabaco y alcohol (No tomar más de 55 ml de whisky, 225 ml de vino o 650 ml de cerveza al día).\n" +
            "- Recuerda mantener un peso corporal  adecuado.";
    static String fumador = "¡Tú puedes!  Mejorar tus hábitos de estilo de vida como es dejar de fumar, " +
            "ya que el tabaquismo es uno de los más importantes factores de riesgo para el desarrollo de enfermedades cardiovasculares como: " +
            "insuficiencia cardíaca, hipertensión arterial, enfermedad cerebrovascular, e infartos al miocardio.\n  ";
    static String menor44 = "¡Te animamos! a que conserves buenos hábitos de vida, ejemplo: \n" +
            "-Realizar actividad física por lo menos 150- 120 minutos semanales. , \n" +
            "-Tener un peso adecuado.\n" +
            "-Una alimentación saludable. \n" +
            "-Manejo del estrés.";
    static String mayor44 = "¡Tú  puedes disminuir la probabilidad de tener una enfermedad!\n" +
            "¡Te animamos!, a que adoptes hábitos de vida saludable, tales como: \n" +
            "-Dieta equilibrada\n" +
            "-Actividad física. \n" +
            "-Peso adecuado. \n" +
            "-Abstenerse de consumir licor y cigarrillo.\n";
}