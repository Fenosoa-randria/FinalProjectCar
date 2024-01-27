package monpackage.ventevoiture.Repository;

import monpackage.ventevoiture.model.Voiture;
import monpackage.ventevoiture.model.VoitureCaracteristique;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VoitureCaracteristiqueRepository extends JpaRepository<VoitureCaracteristique,Integer> {
    @Override
    <S extends VoitureCaracteristique> S save(S entity);
}
