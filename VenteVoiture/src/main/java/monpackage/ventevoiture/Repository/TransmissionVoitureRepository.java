package monpackage.ventevoiture.Repository;

import monpackage.ventevoiture.model.TransmissionVoiture;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransmissionVoitureRepository extends JpaRepository<TransmissionVoiture,Integer> {
    List<TransmissionVoiture> findAll();
}
