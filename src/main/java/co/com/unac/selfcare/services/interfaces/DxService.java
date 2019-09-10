package co.com.unac.selfcare.services.interfaces;

import co.com.unac.selfcare.model.Alert;
import co.com.unac.selfcare.model.Dx;
import org.springframework.stereotype.Service;

@Service
public interface DxService {

    Alert postDx(Dx dx);

}
