package unac.selfcare.selfcareapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@Document(collection = "framingham")
@NoArgsConstructor
public class Framingham {

    @Id
    private String documentNumber;
    private String userGender;
    private int userAge;
    private String result;
    private String colesterol;
    private Boolean fuma;
    private String hdl;
    private String paSistolica;
}