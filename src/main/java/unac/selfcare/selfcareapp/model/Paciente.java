package unac.selfcare.selfcareapp.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "pacientes")
@AllArgsConstructor
@NoArgsConstructor
public class Paciente {

    @Id
    private ObjectId userId;
    private String documentId;
    private String name;
    private String lastName;
    private String password;
}