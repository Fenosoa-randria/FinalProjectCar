package monpackage.ventevoiture.Service;

import monpackage.ventevoiture.Repository.AdminStatistiqueRepository;
import monpackage.ventevoiture.model.AdminStatistique;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminStatistiqueService {
    @Autowired
    AdminStatistiqueRepository adminStatistiqueRepository;
    public List<AdminStatistique> getAllStatistique(){
        return adminStatistiqueRepository.findAllStatistique();
    }
}
