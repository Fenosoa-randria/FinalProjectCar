package monpackage.ventevoiture.model;

import jakarta.persistence.*;

@Entity
@Table(name = "voiture" ,schema = "public")
public class Voiture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idVoiture;
    @Column(name = "id_utilisateur")
    private String idUtilisateur;
    @Column(name = "id_marque")
    private int idMarque;
    @Column(name = "id_modele")
    private int idModele;
    @Column(name = "id_categorie")
    private int idCategorie;
    @Column(name = "id_energie")
    private int idEnergie;
    @Column(name = "prix")
    private double prix;
    @Column(name = "id_type_vitesse")
    private int idTypeVitesse;

    public int getIdVoiture() {
        return idVoiture;
    }

    public void setIdVoiture(int idVoiture) {
        this.idVoiture = idVoiture;
    }

    public String getIdUtilisateur() {
        return idUtilisateur;
    }

    public void setIdUtilisateur(String idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    public int getIdMarque() {
        return idMarque;
    }

    public void setIdMarque(int idMarque) {
        this.idMarque = idMarque;
    }

    public int getIdModele() {
        return idModele;
    }

    public void setIdModele(int idModele) {
        this.idModele = idModele;
    }

    public int getIdCategorie() {
        return idCategorie;
    }

    public void setIdCategorie(int idCategorie) {
        this.idCategorie = idCategorie;
    }

    public int getIdEnergie() {
        return idEnergie;
    }

    public void setIdEnergie(int idEnergie) {
        this.idEnergie = idEnergie;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public int getIdTypeVitesse() {
        return idTypeVitesse;
    }

    public void setIdTypeVitesse(int idTypeVitesse) {
        this.idTypeVitesse = idTypeVitesse;
    }
}
