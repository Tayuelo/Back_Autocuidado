package unac.selfcare.selfcareapp.model.web;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@AllArgsConstructor
@Document(collection = "diagnostics")
@NoArgsConstructor
public class Diagnostic {

    @Id
    private String diagnosticId;
    private String domainId;
    private String diagnosticCode;
    private String diagnosticName;
    private String diagnosticDefinition;
    private List<String> caracteristicsList;
}
