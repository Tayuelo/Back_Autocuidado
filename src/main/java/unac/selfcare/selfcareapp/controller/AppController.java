package unac.selfcare.selfcareapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import unac.selfcare.selfcareapp.model.*;
import unac.selfcare.selfcareapp.model.dtos.UserDTO;
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
    public Boolean logInUser(@RequestParam(name = "doc") String documentId,
                             @RequestParam(name = "password") String password) {
        return logInServices.logInUser(documentId, password);
    }

    @PostMapping("/register")
    public User registerUser(@RequestBody UserDTO userDTO) {
        return logInServices.registerUser(userDTO);
    }

    @GetMapping("/users")
    public List<User> getUsers() {
        return logInServices.getUsers();
    }

    @GetMapping("/user/{doc}")
    public User getUser(@PathVariable("doc") String documentId) {
        return logInServices.getUser(documentId);
    }

    // Servicios para CAA
    @GetMapping("/caa/{doc}")
    public CAA getCaaById(@PathVariable("doc") String documentId) {
        return service.getCaaByDocumentId(documentId);
    }

    @PostMapping("/caa")
    public CAA postCaa(@RequestBody CAA caa) {
        return service.postCaa(caa);
    }

    // Servicios para Framingham
    @GetMapping("/framingham{userId}")
    public Framingham getFramingham(@PathVariable("userId") String userId) {
        return service.getFraminghamByDocumentId(userId);
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

    // TODO: Crear servicios para agregar dominios y diagnósticos con los ID's correspondientes
}