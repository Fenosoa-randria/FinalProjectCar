package monpackage.ventevoiture.Service;

import monpackage.ventevoiture.Repository.MarqueVoitureRepository;
import monpackage.ventevoiture.model.CategorieVoiture;
import monpackage.ventevoiture.model.MarqueVoiture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MarqueVoitureService {
    @Autowired
    MarqueVoitureRepository marqueVoitureRepository;
    public List<MarqueVoiture> getAllMarque(){
        return marqueVoitureRepository.findAll();
    }
    public void insererMarque(MarqueVoiture marqueVoiture){
        marqueVoitureRepository.save(marqueVoiture);
    }

}
