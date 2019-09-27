package unac.selfcare.selfcareapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unac.selfcare.selfcareapp.model.CAA;
import unac.selfcare.selfcareapp.model.Dx;
import unac.selfcare.selfcareapp.model.Paciente;
import unac.selfcare.selfcareapp.model.Framingham;

import java.util.List;

@Service
public class ServicesImplementation implements SelfcareServices {

    @Autowired
    private CAARepository caaRepository;
    @Autowired
    private DXRepository dxRepository;
    @Autowired
    private FraminghamRepository framinghamRepository;

    private Logica logic;

    public ServicesImplementation(CAARepository caaRepository, DXRepository dxRepository, FraminghamRepository framinghamRepository) {
        this.caaRepository = caaRepository;
        this.dxRepository = dxRepository;
        this.framinghamRepository = framinghamRepository;
    }

    // Servicios para el Framingham
    @Override
    public Framingham postFramingham(Framingham framingham) {
        return framinghamRepository.save(framingham);
    }

    @Override
    public Framingham getFraminghamById(String userId) {
        return framinghamRepository.findByUserId(userId);
    }

    @Override
    public List<Framingham> getFramingham() {
        return framinghamRepository.findAll();
    }

    // Servicios para el CAA
    @Override
    public CAA postCaa(CAA caa) {
        return caaRepository.save(caa);
    }

    @Override
    public CAA getCaaById(String userId) {
        return caaRepository.findByUserId(userId);
    }

    @Override
    public List<CAA> getCaa() {
        return caaRepository.findAll();
    }

    // Servicios para el Dx
    @Override
    public Dx getDx(String userId) {
        logic = new Logica();

        String resultadoCaa = logic.calcularCaa(getCaaById(userId).getRespuestas());
        String resultadoRcv = logic.calcularRcv(getFraminghamById(userId).getRespuestas());
        String dxFinal = logic.getDx(resultadoCaa, resultadoRcv);
        Dx dx = new Dx(userId, resultadoCaa, resultadoRcv, dxFinal);
        dxRepository.save(dx);
        return dx;
    }
}