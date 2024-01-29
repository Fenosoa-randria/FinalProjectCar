package monpackage.ventevoiture.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import monpackage.ventevoiture.model.MarqueVoiture;

public interface MarqueVoitureRepository extends JpaRepository<MarqueVoiture, Integer> {

    @Override
    <S extends MarqueVoiture> S save(S entity);

    @Transactional
    @Modifying
    @Query("UPDATE MarqueVoiture m SET m.nomMarque = :nom_marque WHERE m.idMarque = :id_marque")
    void updateMarque(int id_marque, String nom_marque);

}
