package unac.selfcare.selfcareapp.services.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import unac.selfcare.selfcareapp.model.CAA;



@Repository
public interface CAARepository extends MongoRepository<CAA, String> {

    CAA findByDocumentId(String documentId);
}
