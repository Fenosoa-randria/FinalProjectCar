package monpackage.ventevoiture.Repository;

import monpackage.ventevoiture.model.ProprietaireVoitureView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProprietaireVoitureRepository extends JpaRepository<ProprietaireVoitureView, Integer> {
    List<ProprietaireVoitureView> findById(int id);

    @Query(value = "SELECT * FROM voiture_view WHERE marque = :idMarque " +
            "AND modele = :idModele AND energie = :idEnergie " +
            "AND prix BETWEEN :prixMin AND :prixMax", nativeQuery = true)
    List<ProprietaireVoitureView> findVoituresByCriteria(@Param("idMarque") String idMarque,
                                         @Param("idModele") String idModele,
                                         @Param("idEnergie") String idEnergie,
                                         @Param("prixMin") double prixMin,
                                         @Param("prixMax") double prixMax);

    @Query(value = "SELECT * FROM voiture_view " +
            "WHERE LOWER(marque) LIKE LOWER(CONCAT('%', :mots, '%')) " +
            "OR LOWER(modele) LIKE LOWER(CONCAT('%', :mots, '%')) " +
            "OR LOWER(categorie) LIKE LOWER(CONCAT('%', :mots, '%')) " +
            "OR LOWER(energie) LIKE LOWER(CONCAT('%', :mots, '%'))", nativeQuery = true)
    List<ProprietaireVoitureView> findVoituresByMots(@Param("mots") String mots);
    long count();

    @Query(value = "SELECT COUNT(*) FROM voiture_view", nativeQuery = true)
    int countTotalVoitures();

    @Query(value = "SELECT * FROM voiture_annonce WHERE etat_annonce = 1",nativeQuery = true)
    List<ProprietaireVoitureView> findVoitureByEtat();

}
