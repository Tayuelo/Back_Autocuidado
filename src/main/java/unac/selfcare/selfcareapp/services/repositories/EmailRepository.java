package unac.selfcare.selfcareapp.services.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import unac.selfcare.selfcareapp.email.Email;

import java.util.List;

@Repository
public interface EmailRepository extends MongoRepository<Email, String> {

    List<Email> findAllByDocumentNumber(String documentNumber);
    Email findByDocumentNumber(String documentNumber);
}