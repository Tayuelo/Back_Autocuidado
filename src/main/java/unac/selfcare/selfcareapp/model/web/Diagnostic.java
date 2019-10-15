package unac.selfcare.selfcareapp.model.web;

import lombok.Data;

import java.util.List;

@Data
public class Diagnostic {

    private String diagnosticId;
    private String code;
    private String diagnosticName;
    private String definition;
    private List<String> caracteristicsList;
}
