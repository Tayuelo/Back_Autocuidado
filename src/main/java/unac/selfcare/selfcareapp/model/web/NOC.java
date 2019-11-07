package unac.selfcare.selfcareapp.model.web;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@AllArgsConstructor
@Document(collection = "noc")
@NoArgsConstructor
public class NOC {

    @Id
    private String id;
    private String diagnosticId;
    private String nocCode;
    private String nocName;
    private String nocDefinition;
    private List<Indicators> indicatorsList;
}