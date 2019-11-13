package unac.selfcare.selfcareapp.services.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import unac.selfcare.selfcareapp.model.Alarma;

import java.util.List;

@Repository
public interface AlarmaRepository extends MongoRepository<Alarma, String> {

    List<Alarma> findByDocumentNumber(String documentNumber);
    List<Alarma> findAllByDocumentNumber(String documentNumber);
}