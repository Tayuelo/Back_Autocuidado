package unac.selfcare.selfcareapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@Document(collection = "dx")
@NoArgsConstructor
public class Dx {

    @Id
    private String documentNumber;
    private String caa;
    private String rcv;
    private String dx;
}
