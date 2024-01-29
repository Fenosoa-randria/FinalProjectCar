package monpackage.ventevoiture.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "voiture_caracteristique")
public class VoitureCaracteristique {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_voiture_caracteristique")
    private Long idVoitureCaracteristique;

    @JoinColumn(name = "id_voiture", nullable = false)
    private int idVoiture;

    @Column(name = "provenance", nullable = false)
    private String provenance;

    @Column(name = "controle_technique", nullable = false)
    private String controleTechnique;

    @Column(name = "kilometrage_compteur", nullable = false)
    private String kilometrageCompteur;

    @Column(name = "nombre_place", nullable = false)
    private String nombrePlace;

    @Column(name = "longueur", nullable = false)
    private String longueur;

    @Column(name = "volume_de_coffre", nullable = false)
    private String volumeDeCoffre;

    @Column(name = "puissance_vehicule", nullable = false)
    private String puissanceVehicule;

    @Column(name = "immatriculation", unique = true, nullable = false)
    private String immatriculation;

    @Column(name = "annee_circulation", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date anneeCirculation;

    public Long getIdVoitureCaracteristique() {
        return idVoitureCaracteristique;
    }

    public void setIdVoitureCaracteristique(Long idVoitureCaracteristique) {
        this.idVoitureCaracteristique = idVoitureCaracteristique;
    }

    public int getIdVoiture() {
        return idVoiture;
    }

    public void setIdVoiture(int idVoiture) {
        this.idVoiture = idVoiture;
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

    public Date getAnneeCirculation() {
        return anneeCirculation;
    }

    public void setAnneeCirculation(Date anneeCirculation) {
        this.anneeCirculation = anneeCirculation;
    }
}