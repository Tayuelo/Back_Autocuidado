package unac.selfcare.selfcareapp.services;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import unac.selfcare.selfcareapp.model.Paciente;

@Repository
public interface SelfcareRepository extends MongoRepository<Paciente, String> {
}
