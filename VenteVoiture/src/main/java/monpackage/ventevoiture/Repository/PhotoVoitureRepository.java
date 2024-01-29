package monpackage.ventevoiture.Repository;

import monpackage.ventevoiture.model.EnergieVoiture;
import monpackage.ventevoiture.model.PhotoVoiture;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PhotoVoitureRepository extends JpaRepository<PhotoVoiture,Integer> {
    @Override
    <S extends PhotoVoiture> S save(S entity);
}
