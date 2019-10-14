package unac.selfcare.selfcareapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import unac.selfcare.selfcareapp.model.*;
import unac.selfcare.selfcareapp.model.dtos.CAADto;
import unac.selfcare.selfcareapp.model.dtos.FraminghamDto;
import unac.selfcare.selfcareapp.model.dtos.UserDTO;
import unac.selfcare.selfcareapp.model.dtos.UserToDx;
import unac.selfcare.selfcareapp.services.LogInServices;
import unac.selfcare.selfcareapp.services.SelfcareServices;

import java.util.List;

@RestController
@RequestMapping("/selfcare")
@CrossOrigin("*")
public class AppController {

    @Autowired
    private SelfcareServices service;
    @Autowired
    private LogInServices logInServices;

    public AppController(SelfcareServices service) {
        this.service = service;
    }

    @GetMapping("/login")
    public Boolean logInUser(@RequestParam(name = "documentNumber") String documentNumber,
                             @RequestParam(name = "password") String password) {
        return logInServices.logInUser(documentNumber, password);
    }

    @PostMapping("/register")
    public User registerUser(@RequestBody UserDTO userDTO) {
        return logInServices.registerUser(userDTO);
    }

    @GetMapping("/users")
    public List<UserToDx> getUsers() {
        return logInServices.getUsers();
    }

    @GetMapping("/user/{doc}")
    public User getUser(@PathVariable("doc") String documentNumber) {
        return logInServices.getUser(documentNumber);
    }

    // Servicios para CAA
    @GetMapping("/caa/{doc}")
    public CAA getCaaByDocumentNumber(@PathVariable("doc") String documentNumber) {
        return service.getCaaByDocumentNumber(documentNumber);
    }

    @PostMapping("/caa")
    public CAA postCaa(@RequestBody CAADto caaDto) {
        return service.postCaa(caaDto);
    }

    // Servicios para Framingham
    @GetMapping("/framingham/{doc}")
    public Framingham getFramingham(@PathVariable("doc") String documentNumber) {
        return service.getFraminghamByDocumentNumber(documentNumber);
    }

    @PostMapping("/framingham")
    public Framingham postFramingham(@RequestBody FraminghamDto framinghamDto) {
        return service.postFramingham(framinghamDto);
    }

    // Servicios DX
    /*
    @GetMapping("/dx/{doc}")
    public Dx getHome(@PathVariable("doc") String documentNumber) {
        return service.getDx(documentNumber);
    }
    */

    // Servicio para obtener el inicio
    @GetMapping("/home")
    public Home getHome(@RequestParam(name = "documentNumber") String documentNumber) {
        return service.getHome(documentNumber);
    }
}