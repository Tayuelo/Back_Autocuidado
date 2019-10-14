package unac.selfcare.selfcareapp.services;

import org.springframework.stereotype.Service;
import unac.selfcare.selfcareapp.model.*;
import unac.selfcare.selfcareapp.model.dtos.CAADto;
import unac.selfcare.selfcareapp.model.dtos.FraminghamDto;

import java.util.List;

@Service
public interface SelfcareServices {

    CAA postCaa(CAADto caaDto);

    CAA getCaaByDocumentNumber(String documentNumber);

    Framingham postFramingham(FraminghamDto framinghamDto);

    Framingham getFraminghamByDocumentNumber(String documentNumber);

    //Dx getDx(String documentNumber);

    List<Domain> getDomainById(String domainId);

    List<Diagnostic> getDiagnosticsById(String domainId);

    List<Diagnostic> saveDiagnostics(String domainId);

    List<Domain> saveDomains(List<Domain> domainList);

    Home getHome(String documentNumber);
}
