package monpackage.ventevoiture.Repository;

import monpackage.ventevoiture.model.CategorieVoiture;
import monpackage.ventevoiture.model.Voiture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VoitureRepository extends JpaRepository<Voiture,Integer> {
    @Override
    <S extends Voiture> S save(S entity);
}
