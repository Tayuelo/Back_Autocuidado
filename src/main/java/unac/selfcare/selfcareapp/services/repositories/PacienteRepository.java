package unac.selfcare.selfcareapp.services.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import unac.selfcare.selfcareapp.model.Paciente;

@Repository
public interface PacienteRepository extends MongoRepository<Paciente, String> {

    Paciente findByDocumentId(String documentId);
}
