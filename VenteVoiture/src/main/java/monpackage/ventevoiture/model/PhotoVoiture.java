package monpackage.ventevoiture.model;

import jakarta.persistence.*;

@Entity
public class PhotoVoiture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_photo;
    @Column(name = "id_voiture")
    private int id_voiture;
    @Column(name = "id_utilisateur")
    private String id_utilisateur;
    @Column(name = "image_voiture")
    private String image_voiture;

    public int getId_voiture() {
        return id_voiture;
    }

    public void setId_voiture(int id_voiture) {
        this.id_voiture = id_voiture;
    }

    public String getId_utilisateur() {
        return id_utilisateur;
    }

    public void setId_utilisateur(String id_utilisateur) {
        this.id_utilisateur = id_utilisateur;
    }

    public String getImage_voiture() {
        return image_voiture;
    }

    public void setImage_voiture(String image_voiture) {
        this.image_voiture = image_voiture;
    }
}
