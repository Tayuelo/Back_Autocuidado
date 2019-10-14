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

    List<Domain> getDomains();

    Domain saveDomain(Domain domain);

    NOC saveNoc(NOC noc);

    List<NOC> getNocsByDiagnosticId(String diagnosticId);

    NIC saveNic(NIC nic);

    List<NIC> getNicsByDiagnosticId(String diagnosticId);

    Home getHome(String documentNumber);

    List<Domain> saveDomains(List<Domain> domainList);
}
