package monpackage.ventevoiture.Repository;

import monpackage.ventevoiture.model.Favoris;
import monpackage.ventevoiture.model.ModelVoiture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface ModelVoitureRepository extends JpaRepository<ModelVoiture,Integer> {
    @Override
    <S extends ModelVoiture> S save(S entity);
    @Transactional
    @Modifying
    @Query("UPDATE ModelVoiture m SET m.nomModel = :nom_modele WHERE m.idModele = :id_modele")
    void updateModele(int id_modele, String nom_modele);

}
