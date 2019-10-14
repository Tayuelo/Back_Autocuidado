package unac.selfcare.selfcareapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;

@Data
@AllArgsConstructor
@Document(collection = "framingham")
@NoArgsConstructor
public class Framingham {

    @Id
    private String documentNumber;
    private char userGender;
    private int userAge;
    ArrayList<Integer> respuestas;
    private String result;
}