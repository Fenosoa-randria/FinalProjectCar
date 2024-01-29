package monpackage.ventevoiture.Service;
import monpackage.ventevoiture.Repository.VoitureRepository;
import monpackage.ventevoiture.model.PhotoVoiture;
import monpackage.ventevoiture.model.Voiture;
import monpackage.ventevoiture.model.VoitureCaracteristique;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class VoitureService {
    @Autowired
    private VoitureRepository voitureRepository;

    @Autowired
    private PhotoVoitureService photoVoitureService;

    @Autowired
    private VoitureCaracteristiqueService voitureCaracteristiqueService;

    @Transactional
    public void insererVoitureAvecPhotosEtCaracteristique(
            Voiture voiture,
            List<PhotoVoiture> photos,
            VoitureCaracteristique caracteristiqueVoiture) {
        Voiture savedVoiture = voitureRepository.save(voiture);

        // Assurez-vous que la voiture a un ID avant d'ajouter les photos
        if (savedVoiture.getIdVoiture() != 0) {
            for (PhotoVoiture photo : photos) {
                photo.setId_voiture(savedVoiture.getIdVoiture());
                photoVoitureService.insererPhoto(photo);
            }
        }
        caracteristiqueVoiture.setIdVoiture(savedVoiture.getIdVoiture());
        voitureCaracteristiqueService.insererVoitureCaracteristique(caracteristiqueVoiture);
    }

}
