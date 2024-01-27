package monpackage.ventevoiture.Repository;

import monpackage.ventevoiture.model.Favoris;
import monpackage.ventevoiture.model.MarqueVoiture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MarqueVoitureRepository extends JpaRepository<MarqueVoiture,Integer> {
    @Override
    <S extends MarqueVoiture> S save(S entity);
}
