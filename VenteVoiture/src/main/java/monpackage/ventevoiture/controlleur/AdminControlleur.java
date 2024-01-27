package monpackage.ventevoiture.controlleur;

import monpackage.ventevoiture.Service.*;
import monpackage.ventevoiture.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
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


}
