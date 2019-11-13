package unac.selfcare.selfcareapp.services.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import unac.selfcare.selfcareapp.email.WebMessage;

import java.util.List;

@Repository
public interface WebMessageRepository extends MongoRepository<WebMessage, String> {

    List<WebMessage> findAllByDocumentNumber(String documentNumber);
    WebMessage findByDocumentNumber(String documentNumber);
}