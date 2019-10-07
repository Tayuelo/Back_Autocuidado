package unac.selfcare.selfcareapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@Document(collection = "diagnostics")
@NoArgsConstructor
public class Diagnostics {

    @Id
    private String domainId;
    private String diagnosticName;
}
