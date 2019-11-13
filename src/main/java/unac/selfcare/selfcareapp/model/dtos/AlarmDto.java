package unac.selfcare.selfcareapp.model.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import unac.selfcare.selfcareapp.model.Pregunta;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AlarmDto {

    private String documentNumber;
    private List<Pregunta> preguntaList;
}