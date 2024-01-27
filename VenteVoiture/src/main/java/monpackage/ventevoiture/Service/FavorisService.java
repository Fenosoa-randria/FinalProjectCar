package monpackage.ventevoiture.Service;

import monpackage.ventevoiture.Repository.FavorisRepository;
import monpackage.ventevoiture.model.Favoris;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FavorisService {
    @Autowired
    FavorisRepository favorisRepository;
    public void inserer(Favoris favoris){
        favorisRepository.save(favoris);
    }
    public void supprimer(String id_user,int id_voiture){
        favorisRepository.deleteByIdVoitureAndIdUtilisateur(id_voiture,id_user);
    }
    public List<Favoris> selectAllFavoris(String id){
        return favorisRepository.findById_utilisateur(id);
    }
}
