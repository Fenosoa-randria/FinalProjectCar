package monpackage.ventevoiture.Service;

import monpackage.ventevoiture.Repository.AdminDemandeRepository;
import monpackage.ventevoiture.model.AdminDemandeAnnonce;
import monpackage.ventevoiture.model.ProprietaireVoitureView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminDemandeService {
    @Autowired
    AdminDemandeRepository adminDemandeRepository;
    public List<AdminDemandeAnnonce> selectAllVoitureDemandeAnnonce() {
        // Appeler la méthode personnalisée du repository
        return adminDemandeRepository.findAll();
    }

    public List<AdminDemandeAnnonce> selectAllByIdVoiture(int id) {
        // Appeler la méthode personnalisée du repository
        return adminDemandeRepository.findAllByIdVoiture(id);
    }
}
