package unac.selfcare.selfcareapp.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Data
@Document(collection = "alarma")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Alarma {

    @Id
    private String id;
    private String documentNumber;
    private Date alarmDate;
    private List<Pregunta> preguntaList;
}