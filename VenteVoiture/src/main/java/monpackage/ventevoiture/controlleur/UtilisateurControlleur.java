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
@CrossOrigin(origins = {"http://finalprojectcar-production-aab1.up.railway.app"})
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

//    @CrossOrigin(origins = {"http://localhost:8100", "http://localhost:4000"})
    @PostMapping("/insertAnnonce")
    public ResponseEntity<String> insertAnnonce(
            @RequestHeader(name = "Authorization") String idUtilisateur,
            @RequestParam int idMarque,
            @RequestParam int idModele,
            @RequestParam int idCategorie,
            @RequestParam int idEnergie,
            @RequestParam int transmissions,
            @RequestParam double prix,
            @RequestParam String[] image_voiture,
            @RequestParam String provenance,
            @RequestParam String controleTechnique,
            @RequestParam String kilometrage,
            @RequestParam String nombreDePlace,
            @RequestParam String longueur,
            @RequestParam String volumeDeCoffre,
            @RequestParam String puissanceDeVehicule,
            @RequestParam String immatriculation,
            @RequestParam Date anneeDeCirculation
    ) {
        try {
            System.out.println("coucou");
            // Créer une voiture
            String id =  idUtilisateur.replace("Bearer ", "");
            String token = String.valueOf(loginService.getIdFromToken(id));
            Voiture voiture = new Voiture();
            voiture.setIdUtilisateur(token);
            voiture.setIdMarque(idMarque);
            voiture.setIdModele(idModele);
            voiture.setIdCategorie(idCategorie);
            voiture.setIdEnergie(idEnergie);
            voiture.setPrix(prix);
            voiture.setIdTypeVitesse(transmissions);

            // Créer une photo pour la voiture
            List<PhotoVoiture> photos = new ArrayList<>();
            for (String image : image_voiture) {
                PhotoVoiture photo = new PhotoVoiture();
                photo.setId_utilisateur(token);
                photo.setImage_voiture(image);
                photos.add(photo);
            }

            // Créer une caractéristique pour la voiture
            VoitureCaracteristique caracteristiqueVoiture = new VoitureCaracteristique();
            caracteristiqueVoiture.setProvenance(provenance);
            caracteristiqueVoiture.setControleTechnique(controleTechnique);
            caracteristiqueVoiture.setNombrePlace(nombreDePlace);
            caracteristiqueVoiture.setVolumeDeCoffre(volumeDeCoffre);
            caracteristiqueVoiture.setPuissanceVehicule(puissanceDeVehicule);
            caracteristiqueVoiture.setImmatriculation(immatriculation);
            caracteristiqueVoiture.setKilometrageCompteur(kilometrage);
            caracteristiqueVoiture.setAnneeCirculation(anneeDeCirculation);
            caracteristiqueVoiture.setLongueur(longueur);

            // Insérer la voiture avec sa photo et sa caractéristique
            voitureService.insererVoitureAvecPhotosEtCaracteristique(voiture, photos, caracteristiqueVoiture);

            return ResponseEntity.ok("Voiture insérée avec succès.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erreur lors de l'insertion de la voiture.");
        }
    }

//    @CrossOrigin(origins = {"http://localhost:8100", "http://localhost:4000"})
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
    @Autowired
    MarqueVoitureService marqueVoitureService;
//    @CrossOrigin(origins = {"http://localhost:8100", "http://localhost:4000"})
    @GetMapping("/selectAllMarque")
    public List<MarqueVoiture> selectAllMarque() {
        try {

            List<MarqueVoiture> listMarque = marqueVoitureService.getAllMarque();
            return listMarque;
        }  catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
    @Autowired
    ModelVoitureService modelVoitureService;
//    @CrossOrigin(origins = {"http://localhost:8100", "http://localhost:4000"})
    @GetMapping("/selectAllModele")
    public List<ModelVoiture> selectAllModele() {
        try {
            List<ModelVoiture> listModele = modelVoitureService.getAllModel();
            return listModele;
        }  catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
    @Autowired
    CategorieVoitureService categorieVoitureService;
//    @CrossOrigin(origins = {"http://localhost:8100", "http://localhost:4000"})
    @GetMapping("/selectAllCategorie")
    public List<CategorieVoiture> selectAllCategorie() {
        try {
            List<CategorieVoiture> listCategorie = categorieVoitureService.getAllCategorie();
            return listCategorie;
        }  catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Autowired
    EnergieVoitureService energieVoitureService;
//    @CrossOrigin(origins = {"http://localhost:8100", "http://localhost:4000"})
    @GetMapping("/selectAllEnergie")
    public List<EnergieVoiture> selectAllEnergie() {
        try {
            List<EnergieVoiture> listEnergie = energieVoitureService.getAllEnergie();
            return listEnergie;
        }  catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Autowired
    TransmissionVoitureService transmissionVoitureService;
//    @CrossOrigin(origins = {"http://localhost:8100", "http://localhost:4000"})
    @GetMapping("/selectAllTransmission")
    public List<TransmissionVoiture> selectAllTransmission() {
        try {
            List<TransmissionVoiture> listTransmission = transmissionVoitureService.selectAllTransmission();
            return listTransmission;
        }  catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

}

