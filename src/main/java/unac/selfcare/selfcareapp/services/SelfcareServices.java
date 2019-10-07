package unac.selfcare.selfcareapp.services;

import org.springframework.stereotype.Service;
import unac.selfcare.selfcareapp.model.*;

import java.util.List;

@Service
public interface SelfcareServices {

    CAA postCaa(CAA caa);

    CAA getCaaByDocumentId(String documentId);

    Framingham postFramingham(Framingham framingham);

    Framingham getFraminghamByDocumentId(String documentId);

    Dx getDx(String documentId);

    List<Domains> getDomainById(String domainId);

    List<Diagnostics> getDiagnosticsById(String domainId);


}
