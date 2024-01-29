package monpackage.ventevoiture.Repository;

import monpackage.ventevoiture.model.CategorieVoiture;
import monpackage.ventevoiture.model.Favoris;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CategorieVoitureRepository extends JpaRepository<CategorieVoiture, Integer> {
    List<CategorieVoiture> findAll();
    @Override
    <S extends CategorieVoiture> S save(S entity);

    @Transactional
    @Modifying
    @Query("UPDATE CategorieVoiture m SET m.nomCategorie = :nom_categorie WHERE m.idCategorie = :id_categorie")
    void updateCategorie(int id_categorie, String nom_categorie);

}
