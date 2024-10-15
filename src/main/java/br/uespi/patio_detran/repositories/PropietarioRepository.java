package br.uespi.patio_detran.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.uespi.patio_detran.models.PropietarioModel;
import java.util.UUID;

@Repository
public interface PropietarioRepository extends JpaRepository<PropietarioModel, UUID> {
}
