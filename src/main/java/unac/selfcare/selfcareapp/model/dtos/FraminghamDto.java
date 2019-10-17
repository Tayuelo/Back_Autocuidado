package unac.selfcare.selfcareapp.model.dtos;

import lombok.Data;

import java.util.ArrayList;

@Data
public class FraminghamDto {

    private String documentNumber;
    private String userGender;
    private int userAge;
    private String colesterol;
    private Boolean fuma;
    private String hdl;
    private String paSistolica;
}
