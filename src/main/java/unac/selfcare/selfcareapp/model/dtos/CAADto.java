package unac.selfcare.selfcareapp.model.dtos;

import lombok.Data;

import java.util.ArrayList;

@Data
public class CAADto {

    private String documentNumber;
    ArrayList<Integer> respuestas;
}