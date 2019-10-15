package unac.selfcare.selfcareapp.services.repositories.web;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import unac.selfcare.selfcareapp.model.web.Domain;

@Repository
public interface DomainRepository extends MongoRepository<Domain, String> {
}
