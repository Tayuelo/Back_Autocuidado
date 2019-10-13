package unac.selfcare.selfcareapp.services;

import org.springframework.stereotype.Service;
import unac.selfcare.selfcareapp.model.*;

import java.util.List;

@Service
public interface SelfcareServices {

    CAA postCaa(CAA caa);

    CAA getCaaByDocumentNumber(String documentNumber);

    Framingham postFramingham(Framingham framingham);

    Framingham getFraminghamByDocumentNumber(String documentNumber);

    Dx getDx(String documentNumber);

    List<Domain> getDomainById(String domainId);

    List<Diagnostics> getDiagnosticsById(String domainId);

    List<Diagnostics> saveDiagnostics(String domainId);

    List<Domain> saveDomains(List<Domain> domainList);
}
