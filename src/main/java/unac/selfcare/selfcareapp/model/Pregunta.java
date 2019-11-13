package unac.selfcare.selfcareapp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Pregunta {

    private String question;
    private String optionYesNo;
    private String howLongOption;
}