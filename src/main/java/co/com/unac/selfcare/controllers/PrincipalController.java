package co.com.unac.selfcare.controllers;

import co.com.unac.selfcare.model.Alert;
import co.com.unac.selfcare.model.Dx;
import co.com.unac.selfcare.services.interfaces.DxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/dx")
public class PrincipalController {

    @Autowired
    private DxService dxService;

    public PrincipalController(DxService dxService) {
        this.dxService = dxService;
    }

    @PostMapping
    public Alert postDx(@RequestBody Dx dx) {
        return dxService.postDx(dx);
    }
}
