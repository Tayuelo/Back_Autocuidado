package unac.selfcare.selfcareapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import unac.selfcare.selfcareapp.model.CAA;
import unac.selfcare.selfcareapp.model.Dx;
import unac.selfcare.selfcareapp.model.Paciente;
import unac.selfcare.selfcareapp.model.Framingham;
import unac.selfcare.selfcareapp.services.SelfcareServices;

import java.util.List;

@RestController
@RequestMapping("/selfcare")
@CrossOrigin("*")
public class AppController {

    @Autowired()
    private SelfcareServices service;

    public AppController(SelfcareServices service) {
        this.service = service;
    }


    // Servicios para CAA
    @GetMapping("/caa")
    public List<CAA> getCaa() {
        return service.getCaa();
    }

    @GetMapping("/caa/{userId}")
    public CAA getCaaById(@PathVariable("userId") String userId) {
        return service.getCaaById(userId);
    }

    @PostMapping("/caa")
    public CAA postCaa(@RequestBody CAA caa) {
        return service.postCaa(caa);
    }

    // Servicios para Framingham
    @GetMapping("/framingham{userId}")
    public Framingham getFramingham(@PathVariable("userId") String userId) {
        return service.getFraminghamById(userId);
    }

    @GetMapping("/framingham")
    public List<Framingham> getRcv() {
        return service.getFramingham();
    }

    @PostMapping("/framingham")
    public Framingham postFramingham(@RequestBody Framingham framingham) {
        return service.postFramingham(framingham);
    }

    // Servicios DX
    @GetMapping("/dx/{userId}")
    public Dx getDx(@PathVariable("userId") String userId) {
        return service.getDx(userId);
    }
}