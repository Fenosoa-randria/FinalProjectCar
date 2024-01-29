package monpackage.ventevoiture.Repository;

import jakarta.persistence.criteria.CriteriaBuilder;
import monpackage.ventevoiture.model.Annonce;
import monpackage.ventevoiture.model.EnergieVoiture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnnonceRepository extends JpaRepository<Annonce, Integer> {
    @Override
    <S extends Annonce> S save(S entity);
}
