package unac.selfcare.selfcareapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import unac.selfcare.selfcareapp.model.web.Indicators;

import java.util.List;

@Data
@AllArgsConstructor
@Document(collection = "dx")
@NoArgsConstructor
public class Dx {

    @Id
    private String documentNumber;
    private String domainName;
    private String diagnosticCode;
    private String diagnosticName;
    private String diagnosticDefinition;
    private String nocCode;
    private String nocName;
    private String nocDefinition;
    private List<Indicators> indicatorsList;
    private String nicCode;
    private String nicName;
    private String nicDefinition;
    private List<String> activitiesList;
}
