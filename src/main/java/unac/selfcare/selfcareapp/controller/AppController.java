package unac.selfcare.selfcareapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import unac.selfcare.selfcareapp.model.CAA;
import unac.selfcare.selfcareapp.model.Paciente;
import unac.selfcare.selfcareapp.model.Framingham;
import unac.selfcare.selfcareapp.model.RCV;

import unac.selfcare.selfcareapp.services.SelfcareServices;

import java.util.List;

@RestController
@RequestMapping("/selfcare")
@CrossOrigin("*")
public class AppController {

    @Autowired(required = true)
    private SelfcareServices service;

    public AppController(SelfcareServices service) {
        this.service = service;
    }

    @GetMapping
    public List<Paciente> getPaciente() {
        return service.getPacientes();
    }

    @PostMapping("/post")
    public Paciente postPaciente(@RequestBody Paciente paciente) {
        return service.postPaciente(paciente);
    }



    @PostMapping("/caa")
    public CAA postCaa(@RequestBody CAA caa) {
        return service.postCaa(caa);
    }

    @PostMapping("/framingham")
    public Framingham postFramingham(@RequestBody Framingham framingham) {
        return service.postFramingham(framingham);

      @GetMapping("/caa")
    public List<CAA> getCaa() {
        return service.getCaa();
    }

    @GetMapping("/rcv")
    public List<RCV> getRcv() {
        return service.getRcv();
    }

    @PostMapping("/rcv")
    public RCV postRcv(@RequestBody RCV rcv) {
        return service.postRcv(rcv);
    }

    @GetMapping("/caa/{userId}")
    public CAA getCaaById(@PathVariable("userId") String userId){
        return service.getCaaById(userId);
    }

    @GetMapping("/rcv/{userId}")
    public RCV getRcvById(@PathVariable("userId") String userId){
        return service.getRcvById(userId);

    }
}

