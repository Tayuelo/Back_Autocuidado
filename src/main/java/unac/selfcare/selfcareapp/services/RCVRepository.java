package unac.selfcare.selfcareapp.services;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RCVRepository extends MongoRepository<RCV, String> {
    RCV findByUserId(String userId);
}
