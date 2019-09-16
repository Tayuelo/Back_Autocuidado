package unac.selfcare.selfcareapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "paciente")
@AllArgsConstructor
@NoArgsConstructor
public class Paciente {

    @Id
    private ObjectId id;
    private int edad;
    private char genero;
    private double peso;
    private double pArterial;
    private String estadoCivil;
    private String ocupacion;
    private String escolaridad;
    private String viveCon;
    private String cuidador;
    private String redApoyo;
}
