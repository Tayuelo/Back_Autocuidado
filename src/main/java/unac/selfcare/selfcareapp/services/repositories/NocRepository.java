package unac.selfcare.selfcareapp.services.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import unac.selfcare.selfcareapp.model.NOC;

import java.util.List;

@Repository
public interface NocRepository extends MongoRepository<NOC, String> {
    List<NOC> findByDiagnosticId(String diagnosicId);
}
