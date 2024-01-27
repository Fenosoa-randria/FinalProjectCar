package monpackage.ventevoiture.Repository;

import monpackage.ventevoiture.model.Admin;
import monpackage.ventevoiture.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;
import java.util.Optional;

public interface AdminRepository extends JpaRepository<Admin, Integer> {
    // Exemple de requête personnalisée pour récupérer les administrateurs par email
    @Query("SELECT a FROM Admin a WHERE a.email = ?1")
    List<Admin> findByEmail(String email);
    Optional<Admin> findAllByEmailAndMotDePasse(String email, String motDePasse);
    UserDetails findAllByIdAdmin(String id);

}
