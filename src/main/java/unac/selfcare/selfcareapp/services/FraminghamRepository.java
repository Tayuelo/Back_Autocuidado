package unac.selfcare.selfcareapp.services;

import org.springframework.data.mongodb.repository.MongoRepository;
import unac.selfcare.selfcareapp.model.CAA;
import unac.selfcare.selfcareapp.model.Framingham;

public interface FraminghamRepository extends MongoRepository<Framingham, String> {
    Framingham findByUserId(String userId);
}
