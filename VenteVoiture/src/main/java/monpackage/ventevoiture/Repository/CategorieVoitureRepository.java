package monpackage.ventevoiture.Repository;

import monpackage.ventevoiture.model.CategorieVoiture;
import monpackage.ventevoiture.model.Favoris;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategorieVoitureRepository extends JpaRepository<CategorieVoiture, Integer> {
    List<CategorieVoiture> findAll();
    @Override
    <S extends CategorieVoiture> S save(S entity);
}
