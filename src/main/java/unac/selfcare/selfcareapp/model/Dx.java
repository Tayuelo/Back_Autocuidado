package unac.selfcare.selfcareapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import unac.selfcare.selfcareapp.model.web.Diagnostic;
import unac.selfcare.selfcareapp.model.web.NIC;
import unac.selfcare.selfcareapp.model.web.NOC;


@Data
@AllArgsConstructor
@Document(collection = "dx")
@NoArgsConstructor
public class Dx {

    @Id
    private String documentNumber;
    private String domainName;
    private Diagnostic diagnostic;
    private NOC noc;
    private NIC nic;
}