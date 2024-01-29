package monpackage.ventevoiture.Service;

import monpackage.ventevoiture.Repository.AdminRepository;
import monpackage.ventevoiture.model.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {
    @Autowired
    private AdminRepository adminRepository;
//    public List<Admin> getAdmin(String email,String motde_passe) {
//        return adminRepository.findAllByEmailAndMotDePasse(email,mot_de_passe);
//    }
}