package monpackage.ventevoiture.Repository;

import monpackage.ventevoiture.model.Favoris;
import monpackage.ventevoiture.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

public interface UtilisateurRepository extends JpaRepository<Utilisateur,Integer> {
    Optional<Utilisateur> findAllByEmailAndMotDePasse(String email, String motDePasse);
    <S extends Utilisateur> S save(S entity);
    UserDetails findAllByIdUtilisateur(String id);

}
