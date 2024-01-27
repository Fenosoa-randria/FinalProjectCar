package monpackage.ventevoiture.Service;

import monpackage.ventevoiture.Repository.AdminRepository;
import monpackage.ventevoiture.Repository.ProprietaireVoitureRepository;
import monpackage.ventevoiture.model.Admin;
import monpackage.ventevoiture.model.ProprietaireVoitureView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProprietaireVoitureService {
    @Autowired
    private ProprietaireVoitureRepository proprietaireRepository;
    public List<ProprietaireVoitureView> getAllVoiture() {
        // Appeler la méthode personnalisée du repository
        return proprietaireRepository.findAll();
    }
    public List<ProprietaireVoitureView> getById(int id) {
        // Appeler la méthode personnalisée du repository
        return proprietaireRepository.findById(id);
    }
    public List<ProprietaireVoitureView> rechercheVoiture(String id1,String id2,String id3, double min, double max) {
        // Appeler la méthode personnalisée du repository
        return proprietaireRepository.findVoituresByCriteria(id1,id2,id3,min,max);
    }
    public List<ProprietaireVoitureView> rechercheMulticritereVoiture(String mots) {
        // Appeler la méthode personnalisée du repository
        return proprietaireRepository.findVoituresByMots(mots);
    }
    public int countVoiture(){
        return proprietaireRepository.countTotalVoitures();
    }

}
