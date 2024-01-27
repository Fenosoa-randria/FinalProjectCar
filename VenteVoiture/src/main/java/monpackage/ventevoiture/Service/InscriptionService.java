package monpackage.ventevoiture.Service;

import monpackage.ventevoiture.Repository.UtilisateurRepository;
import monpackage.ventevoiture.model.CategorieVoiture;
import monpackage.ventevoiture.model.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InscriptionService {
    @Autowired
    UtilisateurRepository utilisateurRepository;
    public void insererUtilisateur(Utilisateur user){
        utilisateurRepository.save(user);
    }
}
