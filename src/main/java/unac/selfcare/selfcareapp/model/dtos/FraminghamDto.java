package unac.selfcare.selfcareapp.model.dtos;

import lombok.Data;

import java.util.ArrayList;

@Data
public class FraminghamDto {

    private String documentNumber;
    private char userGender;
    private int userAge;
    ArrayList<Integer> respuestas;
}
