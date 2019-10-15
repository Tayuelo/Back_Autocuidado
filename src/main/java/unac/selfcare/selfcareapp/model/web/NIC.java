package unac.selfcare.selfcareapp.model.web;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@AllArgsConstructor
@Document(collection = "nic")
@NoArgsConstructor
public class NIC {

    @Id
    private String id;
    private String diagnosticId;
    private String code;
    private String nicName;
    private String definition;
    private List<String> activitiesList;
}
