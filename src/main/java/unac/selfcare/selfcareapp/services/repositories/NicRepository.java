package unac.selfcare.selfcareapp.services.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import unac.selfcare.selfcareapp.model.NIC;

import java.util.List;

@Repository
public interface NicRepository extends MongoRepository<NIC, String> {
    List<NIC> findByDiagnosticId(String diagnosicId);
}
