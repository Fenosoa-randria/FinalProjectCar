package monpackage.ventevoiture.Service;

import monpackage.ventevoiture.Repository.EnergieVoitureRepository;
import monpackage.ventevoiture.model.CategorieVoiture;
import monpackage.ventevoiture.model.EnergieVoiture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnergieVoitureService {
    @Autowired
    EnergieVoitureRepository energieVoitureRepository;

    public List<EnergieVoiture> getAllEnergie(){
        return energieVoitureRepository.findAll();
    }
    public void insererEnergie(EnergieVoiture energieVoiture){
        energieVoitureRepository.save(energieVoiture);
    }
    public  void updateEnergie(int id,String nom){energieVoitureRepository.updateEnergie(id,nom);}

}
