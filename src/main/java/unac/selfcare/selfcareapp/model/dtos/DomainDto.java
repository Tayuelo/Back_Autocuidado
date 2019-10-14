package unac.selfcare.selfcareapp.model.dtos;

import lombok.Data;

import java.util.List;

@Data
public class DomainDto {

    private String domainName;
    private List<DiagnosticDto> diagnosticList;
}
