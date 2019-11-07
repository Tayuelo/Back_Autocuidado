package unac.selfcare.selfcareapp.email;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@AllArgsConstructor
@Document(collection = "emails")
@NoArgsConstructor
@Builder(toBuilder = true)
public class Email {

    @Id
    private String eMailId;
    private String from;
    private String documentNumber;
    private Date date;
    private String tituloEmail;
    private String cuerpoEmail;
}