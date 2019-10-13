package unac.selfcare.selfcareapp.services.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import unac.selfcare.selfcareapp.model.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

    User findByDocumentNumber(String documentId);
}
