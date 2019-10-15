package unac.selfcare.selfcareapp.model.web;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@AllArgsConstructor
@Document(collection = "domains")
@NoArgsConstructor
public class Domain {

    @Id
    private String domainId;
    private String domainName;
    private List<Diagnostic> diagnosticList;
}
