package unac.selfcare.selfcareapp.services;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import unac.selfcare.selfcareapp.model.RCV;

@Repository
public interface RCVRepository extends MongoRepository<RCV, String> {
}
