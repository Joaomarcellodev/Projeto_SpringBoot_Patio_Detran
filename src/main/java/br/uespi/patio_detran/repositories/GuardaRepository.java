package br.uespi.patio_detran.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.uespi.patio_detran.models.GuardaModel;
import java.util.UUID;

@Repository
public interface GuardaRepository extends JpaRepository<GuardaModel, UUID> {
}

