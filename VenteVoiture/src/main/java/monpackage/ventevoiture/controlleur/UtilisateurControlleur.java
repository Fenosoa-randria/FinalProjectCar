package monpackage.ventevoiture.controlleur;

import monpackage.ventevoiture.Service.*;
import monpackage.ventevoiture.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/utilisateur")
public class UtilisateurControlleur {
    @Autowired
    UtilisateurService utilisateurService;

    @Autowired
    VoitureService voitureService;
    @Autowired
    PhotoVoitureService photoVoitureService;
    @Autowired
    VoitureCaracteristiqueService voitureCaracteristiqueService;
    @Autowired
    FavorisService favorisService;
    @Autowired
    LoginService loginService;


    @PostMapping("/insertVoiture")
    public ResponseEntity<String> insertAnnonce(
            @RequestParam String idUtilisateur,
            @RequestParam int idMarque,
            @RequestParam int idModele,
            @RequestParam int idCategorie,
            @RequestParam int idEnergie,
            @RequestParam int idType,
            @RequestParam double prix,
            @RequestParam String[] image_voiture,
            @RequestParam String provenance,
            @RequestParam String controlle_technique,
            @RequestParam String kilometrage_compteur,
            @RequestParam String nombre_place,
            @RequestParam String longueur,
            @RequestParam String volume_de_coffre,
            @RequestParam String puissance_vehicule,
            @RequestParam String immatriculation,
            @RequestParam Date annee_circulation
    ) {
        try {
            // Créer une voiture
            Voiture voiture = new Voiture();
            voiture.setIdUtilisateur(idUtilisateur);
            voiture.setIdMarque(idMarque);
            voiture.setIdModele(idModele);
            voiture.setIdCategorie(idCategorie);
            voiture.setIdEnergie(idEnergie);
            voiture.setPrix(prix);
            voiture.setIdTypeVitesse(idType);

            // Créer une photo pour la voiture
            List<PhotoVoiture> photos = new ArrayList<>();
            for (String image : image_voiture) {
                PhotoVoiture photo = new PhotoVoiture();
                photo.setId_utilisateur(idUtilisateur);
                photo.setImage_voiture(image);
                photos.add(photo);
            }

            // Créer une caractéristique pour la voiture
            VoitureCaracteristique caracteristiqueVoiture = new VoitureCaracteristique();
            caracteristiqueVoiture.setProvenance(provenance);
            caracteristiqueVoiture.setControleTechnique(controlle_technique);
            caracteristiqueVoiture.setNombrePlace(nombre_place);
            caracteristiqueVoiture.setVolumeDeCoffre(volume_de_coffre);
            caracteristiqueVoiture.setPuissanceVehicule(puissance_vehicule);
            caracteristiqueVoiture.setImmatriculation(immatriculation);
            caracteristiqueVoiture.setKilometrageCompteur(kilometrage_compteur);
            caracteristiqueVoiture.setAnneeCirculation(annee_circulation);
            caracteristiqueVoiture.setLongueur(longueur);

            // Insérer la voiture avec sa photo et sa caractéristique
            voitureService.insererVoitureAvecPhotosEtCaracteristique(voiture, photos, caracteristiqueVoiture);

            return ResponseEntity.ok("Voiture insérée avec succès.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erreur lors de l'insertion de la voiture.");
        }
    }

    @CrossOrigin(origins = {"http://localhost:8100", "http://localhost:4000"})
    @GetMapping("/selectAllFavoris")
    public List<Favoris> selectAllFavoris(@RequestHeader(name = "Authorization") String id_user) {
        try {
          String id =  id_user.replace("Bearer ", "");
            String token = String.valueOf(loginService.getIdFromToken(id));
            // Get the connection
            List<Favoris> listFavoris = favorisService.selectAllFavoris(token);
            return listFavoris;
        }  catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
    @PostMapping("/insertFavoris")
    public ResponseEntity<String> insertUser(@RequestHeader(name = "Authorization") String id_user, @RequestParam int id_voiture) {
        try {
            String id =  id_user.replace("Bearer ", "");
            String token = String.valueOf(loginService.getIdFromToken(id));
            Favoris fav = new Favoris();
            fav.setId_voiture(id_voiture);
            fav.setId_utilisateur(token);
            favorisService.inserer(fav);
            return ResponseEntity.ok("Favoris inséré avec succès.");
        } catch (Exception e) {
            System.out.println(e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erreur lors de l'insertion.");
        }
    }

    @PostMapping("/deleteFavoris")
    public ResponseEntity<String> deleteUser(@RequestHeader(name = "Authorization") String id_user, @RequestParam int id_voiture) {
        try {
            String id =  id_user.replace("Bearer ", "");
            String token = String.valueOf(loginService.getIdFromToken(id));
            favorisService.supprimer(token,id_voiture);

            return ResponseEntity.ok("Favoris supprimer avec succès.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erreur lors de l'insertion.");
        }
    }


}

