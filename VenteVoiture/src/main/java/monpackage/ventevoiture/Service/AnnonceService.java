package monpackage.ventevoiture.Service;

import monpackage.ventevoiture.Repository.AnnonceRepository;
import monpackage.ventevoiture.model.Annonce;
import monpackage.ventevoiture.model.CategorieVoiture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnnonceService {
    @Autowired
    AnnonceRepository annonceRepository;
    public void insererAnnonce(Annonce annonce){
        annonceRepository.save(annonce);
    }
}
