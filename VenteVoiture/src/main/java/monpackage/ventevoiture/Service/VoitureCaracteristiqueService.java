package monpackage.ventevoiture.Service;

import monpackage.ventevoiture.Repository.VoitureCaracteristiqueRepository;
import monpackage.ventevoiture.model.VoitureCaracteristique;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VoitureCaracteristiqueService {
    @Autowired
    VoitureCaracteristiqueRepository voitureCaracteristiqueRepository;
    public void insererVoitureCaracteristique(VoitureCaracteristique model){
        voitureCaracteristiqueRepository.save(model);
    }

}
