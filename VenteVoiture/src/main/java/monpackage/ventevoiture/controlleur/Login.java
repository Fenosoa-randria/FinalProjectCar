package monpackage.ventevoiture.controlleur;

import monpackage.ventevoiture.Service.InscriptionService;
import monpackage.ventevoiture.Service.LoginService;
import monpackage.ventevoiture.model.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/login")
public class Login {

    @Autowired
    LoginService loginService;

    @Autowired
    InscriptionService inscriptionService;

    @PostMapping("/verificationLogin")
    public ResponseEntity verificationLogin(@RequestParam String email, @RequestParam String motdepasse) {
        try {
            String[] result = loginService.verificationLogin(email, motdepasse);
            if (result != null) {
                String token = result[0];
                String userType = result[1];
                return ResponseEntity.ok( token + "," + userType);
            } else {
                return ResponseEntity.ok("0");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erreur lors de la vérification du login");
        }
    }
    @PostMapping("/insertUtilisateur")
    public ResponseEntity<String> insertUser(@RequestParam String nom, @RequestParam String prenom, @RequestParam Date datenaissance, @RequestParam String email, @RequestParam String motdepasse, @RequestParam String motdepasseconfirm ){
        try {
            if (motdepasse.equals(motdepasseconfirm)) {
                Utilisateur user = new Utilisateur();
                user.setNom(nom);
                user.setPrenom(prenom);
                user.setDateDeNaissance(datenaissance);
                user.setEmail(email);
                user.setMotDePasse(motdepasse);
                inscriptionService.insererUtilisateur(user);
                return ResponseEntity.ok("Utilisateur inséré avec succès.");
            }else{
                return ResponseEntity.ok("Verifier bien votre mot de passe.");
            }

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Email existe deja");
        }
    }
}
