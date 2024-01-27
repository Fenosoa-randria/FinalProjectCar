package monpackage.ventevoiture.Repository;

import jakarta.transaction.Transactional;
import monpackage.ventevoiture.model.Admin;
import monpackage.ventevoiture.model.Favoris;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FavorisRepository extends JpaRepository<Favoris,Integer> {
    @Override
    <S extends Favoris> S save(S entity);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM Favoris f WHERE f.id_voiture = :idVoiture AND f.id_utilisateur = :idUtilisateur")
    void deleteByIdVoitureAndIdUtilisateur(int idVoiture, String idUtilisateur);

    @Query("SELECT f FROM Favoris f WHERE f.id_utilisateur = ?1")
    List<Favoris> findById_utilisateur(String id_utilisateur);}
