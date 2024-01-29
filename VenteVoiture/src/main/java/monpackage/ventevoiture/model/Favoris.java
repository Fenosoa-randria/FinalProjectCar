package monpackage.ventevoiture.model;

import jakarta.persistence.*;
import monpackage.ventevoiture.Service.FavorisService;
import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Table(name = "favoris",schema = "public")
public class Favoris {
    @Id
    private int id_voiture;
    @Column(name = "id_utilisateur")
    private String id_utilisateur;

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
}
