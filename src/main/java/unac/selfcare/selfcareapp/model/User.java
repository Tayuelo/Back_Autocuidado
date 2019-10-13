package unac.selfcare.selfcareapp.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "user")
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    private String userId;
    private String documentId;
    private String name;
    private String lastName;
    private String password;
    private String userRol;
}