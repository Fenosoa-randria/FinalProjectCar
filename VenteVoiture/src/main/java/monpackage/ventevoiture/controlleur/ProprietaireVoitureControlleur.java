package monpackage.ventevoiture.controlleur;
import monpackage.ventevoiture.Service.*;
import monpackage.ventevoiture.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin(origins = {"http://*"})

@RequestMapping("/api/accueil")
public class ProprietaireVoitureControlleur {
    @Autowired
    ProprietaireVoitureService proprio;
    @Autowired
    CategorieVoitureService categorieVoitureService;
    @Autowired
    EnergieVoitureService energieVoitureService;
    @Autowired
    MarqueVoitureService marqueVoitureService;
    @Autowired
    ModelVoitureService modelVoitureService;

    @Autowired
    FavorisService favorisService;
    @Autowired
    UtilisateurService utilisateurService;
    @Autowired
    PhotoVoitureService photoVoitureService;


    @GetMapping("/selectAllVoiture")
    public List<ProprietaireVoitureView> selectAllVoiture() {
        try {
            // Get the connection
            List<ProprietaireVoitureView> listeUtilisateur = proprio.getAllVoiture();
            return listeUtilisateur;
        }  catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @GetMapping("/selectAllPhotoVoiture")
    public List<PhotoVoiture> selectAllPhotoVoiture() {
        try {
            // Get the connection
            List<PhotoVoiture> listePhoto = photoVoitureService.selectAllPhoto();

            return listePhoto;
        }  catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
    @GetMapping("/selectCountVoiture")
    public int selectCountVoiture() {
        return proprio.countVoiture();
    }

    @GetMapping("/selectByIdVoiture")
    public ResponseEntity<List<ProprietaireVoitureView>> selectByIdVoiture(@RequestParam int id_voiture) {
            List<ProprietaireVoitureView> listeVoitures = proprio.getById(id_voiture);
            if (listeVoitures != null && !listeVoitures.isEmpty()) {
                return ResponseEntity.ok(listeVoitures);
            } else {
                return ResponseEntity.notFound().build();
            }
      }
    @GetMapping("/selectAllProposVoiture")
    public ProposVoitureResponse selectAllProposVoiture() {
        try {
            // Récupérez les listes
            List<CategorieVoiture> listeCategorie = categorieVoitureService.getAllCategorie();
            List<ModelVoiture> listeModel = modelVoitureService.getAllModel();
            List<EnergieVoiture> listeEnergie = energieVoitureService.getAllEnergie();
            List<MarqueVoiture> listeMarque = marqueVoitureService.getAllMarque();
            // Créez l'objet de réponse
            ProposVoitureResponse response = new ProposVoitureResponse();
            response.setCategories(listeCategorie);
            response.setModeles(listeModel);
            response.setEnergies(listeEnergie);
            response.setMarques(listeMarque);
            return response;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
    @GetMapping("/rechercheVoiture")
    public ResponseEntity<List<ProprietaireVoitureView>> rechercheVoiture(@RequestParam String Marque, @RequestParam String Modele, @RequestParam String Energie, @RequestParam double prixMin, @RequestParam double prixMax) {
            List<ProprietaireVoitureView> listeVoitures = proprio.rechercheVoiture(Marque,Modele,Energie,prixMin,prixMax);
            if (listeVoitures != null && !listeVoitures.isEmpty()) {
                return ResponseEntity.ok(listeVoitures);
            } else {
                return ResponseEntity.notFound().build();
            }

    }
    @GetMapping("/rechercheAllVoiture")
    public List<ProprietaireVoitureView> rechercheAllVoiture(@RequestParam String mots) {
        try {
            // Get the connection
            List<ProprietaireVoitureView> listeUtilisateur = proprio.rechercheMulticritereVoiture(mots);

            return listeUtilisateur;
        }  catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
    @Autowired
    MieuxVisiterService mieuxVisiterService;
    @GetMapping("/selectAllMieuxVisite")
    public List<MieuxVisiter> selectAllVisite() {
        try {
            // Get the connection
            List<MieuxVisiter> listMieux = mieuxVisiterService.selectAllMieuxVisite();
            return listMieux;
        }  catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
