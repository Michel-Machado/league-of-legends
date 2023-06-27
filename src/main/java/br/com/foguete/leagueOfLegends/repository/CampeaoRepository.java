package br.com.foguete.leagueOfLegends.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository

public interface CampeaoRepository extends MongoRepository<CampeaoControl, String> {
    Optional<CampeaoControl> findByNome(String nome);

    Optional<CampeaoControl> findById(String id);
}
