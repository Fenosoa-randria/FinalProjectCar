package monpackage.ventevoiture.model;
import jakarta.persistence.*;

@Entity
@Table(name = "categorie", schema = "public")
public class CategorieVoiture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCategorie;
    @Column(name = "nom_categorie")
    private String nomCategorie;

    // Constructors, getters, and setters
    public CategorieVoiture() {
    }

    public CategorieVoiture(int idCategorie, String nomCategorie) {
        this.idCategorie = idCategorie;
        this.nomCategorie = nomCategorie;
    }
    public int getIdCategorie() {
        return idCategorie;
    }

    public void setIdCategorie(int idCategorie) {
        this.idCategorie = idCategorie;
    }

    public String getNomCategorie() {
        return nomCategorie;
    }

    public void setNomCategorie(String nomCategorie) {
        this.nomCategorie = nomCategorie;
    }

}
