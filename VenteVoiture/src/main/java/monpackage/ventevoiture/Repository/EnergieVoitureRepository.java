package monpackage.ventevoiture.Repository;

import monpackage.ventevoiture.model.EnergieVoiture;
import monpackage.ventevoiture.model.Favoris;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnergieVoitureRepository extends JpaRepository<EnergieVoiture,Integer> {
    @Override
    <S extends EnergieVoiture> S save(S entity);
}
