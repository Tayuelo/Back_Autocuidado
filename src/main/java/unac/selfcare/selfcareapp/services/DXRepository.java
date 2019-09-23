package unac.selfcare.selfcareapp.services;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import unac.selfcare.selfcareapp.model.Dx;

@Repository
public interface DXRepository extends MongoRepository<Dx, String> {
}
