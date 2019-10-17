package unac.selfcare.selfcareapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import unac.selfcare.selfcareapp.model.*;
import unac.selfcare.selfcareapp.model.dtos.CAADto;
import unac.selfcare.selfcareapp.model.dtos.FraminghamDto;
import unac.selfcare.selfcareapp.model.dtos.UserDTO;
import unac.selfcare.selfcareapp.model.dtos.UserToDx;
import unac.selfcare.selfcareapp.model.Home;
import unac.selfcare.selfcareapp.model.web.Diagnostic;
import unac.selfcare.selfcareapp.model.web.Domain;
import unac.selfcare.selfcareapp.model.web.NIC;
import unac.selfcare.selfcareapp.model.web.NOC;
import unac.selfcare.selfcareapp.services.LogInServices;
import unac.selfcare.selfcareapp.services.SelfcareServices;
import unac.selfcare.selfcareapp.utils.FirstLogin;

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
    public FirstLogin logInUser(@RequestParam(name = "documentNumber") String documentNumber,
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

    @GetMapping("/caa/{doc}")
    public CAA getCaaByDocumentNumber(@PathVariable("doc") String documentNumber) {
        return service.getCaaByDocumentNumber(documentNumber);
    }

    @PostMapping("/caa")
    public CAA postCaa(@RequestBody CAADto caaDto) {
        return service.postCaa(caaDto);
    }

    @GetMapping("/framingham/{doc}")
    public Framingham getFramingham(@PathVariable("doc") String documentNumber) {
        return service.getFraminghamByDocumentNumber(documentNumber);
    }

    @PostMapping("/framingham")
    public Framingham postFramingham(@RequestBody FraminghamDto framinghamDto) {
        return service.postFramingham(framinghamDto);
    }

    @GetMapping("/home/{documentNumber}")
    public Home getHome(@PathVariable("documentNumber") String documentNumber) {
        return service.getHome(documentNumber);
    }

    @GetMapping("/domains")
    public List<Domain> getDomains() {
        return service.getDomains();
    }

    @PostMapping("/domain")
    public Domain saveDomain(@RequestBody Domain domain) {
        return service.saveDomain(domain);
    }

    @PostMapping("/nic")
    public NIC saveNic(@RequestBody NIC nic) {
        return service.saveNic(nic);
    }

    @GetMapping("/nic/{diagnosticId}")
    public List<NIC> getNicsByDiagnosticId(@PathVariable("diagnosticId") String diagnosticId) {
        return service.getNicsByDiagnosticId(diagnosticId);
    }

    @PostMapping("/noc")
    public NOC saveNoc(@RequestBody NOC noc) {
        return service.saveNoc(noc);
    }

    @GetMapping("/noc/{diagnosticId}")
    public List<NOC> getNocsByDiagnosticId(@PathVariable("diagnosticId") String diagnosticId) {
        return service.getNocsByDiagnosticId(diagnosticId);
    }

    @GetMapping("/diagnostic/{domainId}")
    public List<Diagnostic> getDiagnosticsByDomainId(@PathVariable("domainId") String domainId) {
        return service.getDiagnosticsByDomainId(domainId);
    }

    @PostMapping("/diagnostic")
    public Diagnostic saveDiagnostic(@RequestBody Diagnostic diagnostic) {
        return service.saveDiagnostic(diagnostic);
    }

    @GetMapping("/finalDx/{documentNumber}")
    public Dx getDxByDocumentNumber(@PathVariable("documentNumber") String documentNumber) {
        return service.getDx(documentNumber);
    }

    @PostMapping("/finalDx")
    public Dx saveDx(@RequestBody Dx dx) {
        return service.saveDx(dx);
    }
}