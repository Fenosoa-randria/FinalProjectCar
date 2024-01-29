package monpackage.ventevoiture.Repository;

import monpackage.ventevoiture.model.EnergieVoiture;
import monpackage.ventevoiture.model.Favoris;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface EnergieVoitureRepository extends JpaRepository<EnergieVoiture,Integer> {
    @Override
    <S extends EnergieVoiture> S save(S entity);
    @Transactional
    @Modifying
    @Query("UPDATE EnergieVoiture m SET m.nomEnergie = :nom_energie WHERE m.idEnergie = :id_energie")
    void updateEnergie(int id_energie, String nom_energie);

}
