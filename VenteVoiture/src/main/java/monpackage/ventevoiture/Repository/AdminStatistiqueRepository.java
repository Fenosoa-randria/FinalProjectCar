package monpackage.ventevoiture.Repository;

import monpackage.ventevoiture.model.AdminStatistique;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AdminStatistiqueRepository extends JpaRepository<AdminStatistique,Integer> {
    @Query(value = "select count(marque) as nombre,marque,extract(year from annee_circulation) as annee from voiture_view group by marque,annee_circulation order by annee_circulation asc",nativeQuery = true)
    List<AdminStatistique> findAllStatistique();
}
