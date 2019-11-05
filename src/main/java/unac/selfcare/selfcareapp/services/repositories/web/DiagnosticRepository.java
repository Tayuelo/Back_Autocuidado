package unac.selfcare.selfcareapp.services.repositories.web;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import unac.selfcare.selfcareapp.model.web.Diagnostic;

import java.util.List;

@Repository
public interface DiagnosticRepository extends MongoRepository<Diagnostic, String> {
    List<Diagnostic> findAllByDomainId(String domainId);
    List<Diagnostic> findAllByDomainName(String domainName);
}