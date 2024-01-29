package monpackage.ventevoiture.model;

import jakarta.persistence.*;

@Entity
@Table(name = "annonce",schema = "public")
public class Annonce {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id_annonce;
    @Column(name = "id_voiture")
    int id_voiture;
    @Column(name = "id_admin")
    String id_admin;
    @Column(name = "id_utilisateur")
    String id_utilisateur;

    public String getId_utilisateur() {
        return id_utilisateur;
    }

    public void setId_utilisateur(String id_utilisateur) {
        this.id_utilisateur = id_utilisateur;
    }

    @Column(name = "etat_annonce")
    int etat;

    public int getId_annonce() {
        return id_annonce;
    }

    public void setId_annonce(int id_annonce) {
        this.id_annonce = id_annonce;
    }

    public int getId_voiture() {
        return id_voiture;
    }

    public void setId_voiture(int id_voiture) {
        this.id_voiture = id_voiture;
    }

    public String getId_admin() {
        return id_admin;
    }

    public void setId_admin(String id_admin) {
        this.id_admin = id_admin;
    }

    public int getEtat() {
        return etat;
    }

    public void setEtat(int etat) {
        this.etat = etat;
    }
}
