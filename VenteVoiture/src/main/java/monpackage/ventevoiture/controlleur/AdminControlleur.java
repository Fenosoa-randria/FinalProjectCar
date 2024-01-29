package monpackage.ventevoiture.controlleur;

import monpackage.ventevoiture.Service.*;
import monpackage.ventevoiture.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")

public class AdminControlleur {
    @Autowired
    CategorieVoitureService categorieVoitureService;
    @Autowired
    ModelVoitureService modelVoitureService;
    @Autowired
    EnergieVoitureService energieVoitureService;
    @Autowired
    MarqueVoitureService marqueVoitureService;
    @Autowired
    AnnonceService annonceService;
    @Autowired
    LoginService loginService;
    @Autowired
    AdminDemandeService adminDemandeService;

    @Autowired
    AdminStatistiqueService adminStatistiqueService;
    @PostMapping("/insertcategorie")
    public ResponseEntity<String> insertCategorie(@RequestParam String nom) {
        try {
            CategorieVoiture table = new CategorieVoiture();
            table.setNomCategorie(nom);
            categorieVoitureService.insererCategorie(table);
            return ResponseEntity.ok("Categorie inséré avec succès.");
        } catch (Exception e) {
            System.out.println(e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erreur lors de l'insertion.");
        }
    }

    @PostMapping("/insertmodele")
    public ResponseEntity<String> insertModele(@RequestParam String nom) {
        try {
            ModelVoiture table = new ModelVoiture();
            table.setNomModel(nom);
            modelVoitureService.insererModel(table);
            return ResponseEntity.ok("Modele inséré avec succès.");
        } catch (Exception e) {
            System.out.println(e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erreur lors de l'insertion.");
        }
    }

    @PostMapping("/insertmarque")
    public ResponseEntity<String> insertMarque(@RequestParam String nom) {
        try {
            MarqueVoiture table = new MarqueVoiture();
            table.setNomMarque(nom);
            marqueVoitureService.insererMarque(table);
            return ResponseEntity.ok("Marque inséré avec succès.");
        } catch (Exception e) {
            System.out.println(e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erreur lors de l'insertion.");
        }
    }

    @PostMapping("/insertenergie")
    public ResponseEntity<String> insertEnergie(@RequestParam String nom) {
        try {
            EnergieVoiture table = new EnergieVoiture();
            table.setNomEnergie(nom);
            energieVoitureService.insererEnergie(table);
            return ResponseEntity.ok(" inséré avec succès.");
        } catch (Exception e) {
            System.out.println(e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erreur lors de l'insertion.");
        }
    }

    @PostMapping("/insertAcceptAnnonce")
    public ResponseEntity<String> insertAcceptAnnonce(@RequestHeader(name = "Authorization") String id_admin,@RequestParam String id_user, @RequestParam int id_voiture) {
        try {
            String id =  id_admin.replace("Bearer ", "");
            String token = String.valueOf(loginService.getIdFromToken(id));
            Annonce annonce = new Annonce();
            annonce.setId_voiture(id_voiture);
            annonce.setId_utilisateur(id_user);
            annonce.setId_admin(token);
            annonce.setEtat(1);

            annonceService.insererAnnonce(annonce);
            return ResponseEntity
                    .ok("Annonce accepté avec succès.");
        } catch (Exception e) {
            System.out.println(e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erreur lors de l'insertion.");
        }
    }
    @PostMapping("/insertRefuseAnnonce")
    public ResponseEntity<String> insertRefuseAnnonce(@RequestHeader(name = "Authorization") String id_admin,@RequestParam String id_user, @RequestParam int id_voiture) {
        try {
            String id =  id_admin.replace("Bearer ", "");
            String token = String.valueOf(loginService.getIdFromToken(id));
            Annonce annonce = new Annonce();
            annonce.setId_admin(token);
            annonce.setId_voiture(id_voiture);
            annonce.setId_utilisateur(id_user);
            annonce.setEtat(0);
            annonceService.insererAnnonce(annonce);
            return ResponseEntity.ok("Annonce refusé avec succès.");
        } catch (Exception e) {
            System.out.println(e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erreur lors de l'insertion.");
        }
    }

    @CrossOrigin(origins = {"*"})
    @GetMapping("/selectAllVoitureDemandeAnnonce")
    public List<AdminDemandeAnnonce> selectAllVoitureDemande() {
        try {
            // Get the connection
            List<AdminDemandeAnnonce> listeUtilisateur = adminDemandeService.selectAllVoitureDemandeAnnonce();
            return listeUtilisateur;
        }  catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @CrossOrigin(origins = {"*"})
    @GetMapping("/selectAllByIdVoiture")
    public List<AdminDemandeAnnonce> selectAllByIdVoiture(@RequestParam int id_voiture) {
        try {
            // Get the connection
            List<AdminDemandeAnnonce> listeUtilisateur = adminDemandeService.selectAllByIdVoiture(id_voiture);

            return listeUtilisateur;
        }  catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @CrossOrigin(origins = {"*"})
    @GetMapping("/SelectStatistiqueMarque")
    public ResponseEntity<List<AdminStatistique>> selectAllStatistique() {
        try {
            // Get the connection
            List<AdminStatistique> listeStat = adminStatistiqueService.getAllStatistique();
            return ResponseEntity.ok(listeStat);
        }  catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
    @CrossOrigin(origins = {"*"})
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
    @CrossOrigin(origins = {"*"})
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
    @CrossOrigin(origins = {"*"})
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

    @CrossOrigin(origins = {"*"})
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
    @PostMapping("/updateMarque")
    public ResponseEntity<String> updateMarque(@RequestParam int id,@RequestParam String nom) {
        try {
            marqueVoitureService.updateMarque(id,nom);
            return ResponseEntity.ok(" Marque updater avec succès.");
        } catch (Exception e) {
            System.out.println(e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erreur lors de l'update.");
        }
    }
    @PostMapping("/updateCategorie")
    public ResponseEntity<String> updateCategorie(@RequestParam  int id,@RequestParam String nom) {
        try {
            categorieVoitureService.updateCategorie(id,nom);
            return ResponseEntity.ok(" Categorie updater avec succès.");
        } catch (Exception e) {
            System.out.println(e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erreur lors de l'update.");
        }
    }
    @PostMapping("/updateEnergie")
    public ResponseEntity<String> updateEnergie(@RequestParam int id,@RequestParam String nom) {
        try {
            energieVoitureService.updateEnergie(id,nom);
            return ResponseEntity.ok(" Energie updater avec succès.");
        } catch (Exception e) {
            System.out.println(e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erreur lors de l'update.");
        }
    }
    @PostMapping("/updateModele")
    public ResponseEntity<String> updateModele(@RequestParam int id,@RequestParam String nom) {
        try {
            modelVoitureService.updateModele(id,nom);
            return ResponseEntity.ok(" Modele updater avec succès.");
        } catch (Exception e) {
            System.out.println(e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erreur lors de l'update.");
        }
    }


}
