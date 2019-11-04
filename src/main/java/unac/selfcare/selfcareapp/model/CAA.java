package unac.selfcare.selfcareapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;

@Data
@AllArgsConstructor
@Document(collection = "caa")
@NoArgsConstructor
public class CAA {

    @Id
    private String documentNumber;
    private String result;
    private int answer1;
    private int answer2;
    private int answer3;
    private int answer4;
    private int answer5;
    private int answer6;
    private int answer7;
    private int answer8;
    private int answer9;
    private int answer10;
    private int answer11;
    private int answer12;
    private int answer13;
    private int answer14;
    private int answer15;
    private int answer16;
    private int answer17;
}