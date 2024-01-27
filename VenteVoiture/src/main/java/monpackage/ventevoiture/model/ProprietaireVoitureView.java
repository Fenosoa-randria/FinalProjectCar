package monpackage.ventevoiture.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.sql.Date;

@Entity
@Table(name = "voiture_view", schema = "public")
public class ProprietaireVoitureView {

    @Id
    private int idVoiture;

    @Column(name = "id_utilisateur")
    private String idUtilisateur;


    @Column(name = "marque")
    private String nomMarque;

    @Column(name = "modele")
    private String nomModele;

    @Column(name = "categorie")
    private String nomCategorie;

    @Column(name = "energie")
    private String nomEnergie;
    @Column(name = "type_vitesse")
    private String typeVitesse;

    @Column(name = "prix")
    private double prix;

    @Column(name = "annee_circulation")
    private Date anneeCirculation;

    // New columns
    @Column(name = "provenance")
    private String provenance;

    @Column(name = "controle_technique")
    private String controleTechnique;

    @Column(name = "kilometrage_compteur")
    private String kilometrageCompteur;

    @Column(name = "nombre_place")
    private String nombrePlace;

    @Column(name = "longueur")
    private String longueur;

    @Column(name = "volume_de_coffre")
    private String volumeDeCoffre;

    @Column(name = "puissance_vehicule")
    private String puissanceVehicule;

    @Column(name = "immatriculation")
    private String immatriculation;

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

    public String getNomMarque() {
        return nomMarque;
    }

    public void setNomMarque(String nomMarque) {
        this.nomMarque = nomMarque;
    }

    public String getNomModele() {
        return nomModele;
    }

    public void setNomModele(String nomModele) {
        this.nomModele = nomModele;
    }

    public String getNomCategorie() {
        return nomCategorie;
    }

    public void setNomCategorie(String nomCategorie) {
        this.nomCategorie = nomCategorie;
    }

    public String getNomEnergie() {
        return nomEnergie;
    }

    public void setNomEnergie(String nomEnergie) {
        this.nomEnergie = nomEnergie;
    }

    public String getTypeVitesse() {
        return typeVitesse;
    }

    public void setTypeVitesse(String typeVitesse) {
        this.typeVitesse = typeVitesse;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public Date getAnneeCirculation() {
        return anneeCirculation;
    }

    public void setAnneeCirculation(Date anneeCirculation) {
        this.anneeCirculation = anneeCirculation;
    }

    public String getProvenance() {
        return provenance;
    }

    public void setProvenance(String provenance) {
        this.provenance = provenance;
    }

    public String getControleTechnique() {
        return controleTechnique;
    }

    public void setControleTechnique(String controleTechnique) {
        this.controleTechnique = controleTechnique;
    }

    public String getKilometrageCompteur() {
        return kilometrageCompteur;
    }

    public void setKilometrageCompteur(String kilometrageCompteur) {
        this.kilometrageCompteur = kilometrageCompteur;
    }

    public String getNombrePlace() {
        return nombrePlace;
    }

    public void setNombrePlace(String nombrePlace) {
        this.nombrePlace = nombrePlace;
    }

    public String getLongueur() {
        return longueur;
    }

    public void setLongueur(String longueur) {
        this.longueur = longueur;
    }

    public String getVolumeDeCoffre() {
        return volumeDeCoffre;
    }

    public void setVolumeDeCoffre(String volumeDeCoffre) {
        this.volumeDeCoffre = volumeDeCoffre;
    }

    public String getPuissanceVehicule() {
        return puissanceVehicule;
    }

    public void setPuissanceVehicule(String puissanceVehicule) {
        this.puissanceVehicule = puissanceVehicule;
    }

    public String getImmatriculation() {
        return immatriculation;
    }

    public void setImmatriculation(String immatriculation) {
        this.immatriculation = immatriculation;
    }
// Getters and setters for new columns

}
