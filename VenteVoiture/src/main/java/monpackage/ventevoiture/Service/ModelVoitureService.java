package monpackage.ventevoiture.Service;

import monpackage.ventevoiture.Repository.ModelVoitureRepository;
import monpackage.ventevoiture.model.CategorieVoiture;
import monpackage.ventevoiture.model.ModelVoiture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModelVoitureService {
    @Autowired
    ModelVoitureRepository modelVoitureRepository;
    public List<ModelVoiture> getAllModel(){
        return modelVoitureRepository.findAll();
    }
    public void insererModel(ModelVoiture model){
        modelVoitureRepository.save(model);
    }
    public  void updateModele(int id,String nom){modelVoitureRepository.updateModele(id,nom);}

}
