package monpackage.ventevoiture.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "mieux_visiter",schema = "public")
public class MieuxVisiter {
    @Id
    private int id_mieux_visite;
    @Column(name = "nom_visite")
    private String nom_visite;
    @Column(name = "photo")
    private String photo;

    public int getId_mieux_visite() {
        return id_mieux_visite;
    }

    public void setId_mieux_visite(int id_mieux_visiter) {
        this.id_mieux_visite = id_mieux_visiter;
    }

    public String getNom_visite() {
        return nom_visite;
    }

    public void setNom_visite(String nom_visite) {
        this.nom_visite = nom_visite;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
