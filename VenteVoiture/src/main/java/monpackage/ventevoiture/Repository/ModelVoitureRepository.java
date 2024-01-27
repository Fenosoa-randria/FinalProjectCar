package monpackage.ventevoiture.Repository;

import monpackage.ventevoiture.model.Favoris;
import monpackage.ventevoiture.model.ModelVoiture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModelVoitureRepository extends JpaRepository<ModelVoiture,Integer> {
    @Override
    <S extends ModelVoiture> S save(S entity);
}
