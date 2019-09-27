package unac.selfcare.selfcareapp.services;

import org.springframework.stereotype.Service;
import unac.selfcare.selfcareapp.model.CAA;
import unac.selfcare.selfcareapp.model.Dx;
import unac.selfcare.selfcareapp.model.Paciente;
import unac.selfcare.selfcareapp.model.Framingham;

import java.util.List;

@Service
public interface SelfcareServices {

    CAA postCaa(CAA caa);

    List<CAA> getCaa();

    CAA getCaaById(String userId);

    Framingham postFramingham(Framingham framingham);

    List<Framingham> getFramingham();

    Framingham getFraminghamById(String userId);

    Dx getDx(String userId);
}
