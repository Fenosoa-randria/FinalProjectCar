package monpackage.ventevoiture.Service;

import monpackage.ventevoiture.Repository.CategorieVoitureRepository;
import monpackage.ventevoiture.model.CategorieVoiture;
import monpackage.ventevoiture.model.Favoris;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategorieVoitureService {
    @Autowired
    private CategorieVoitureRepository categorieVoitureRepository;
    public List<CategorieVoiture> getAllCategorie(){
        return categorieVoitureRepository.findAll();
    }

    public void insererCategorie(CategorieVoiture categorie){
        categorieVoitureRepository.save(categorie);
    }
    public  void updateCategorie(int id,String nom){categorieVoitureRepository.updateCategorie(id,nom);}
}
