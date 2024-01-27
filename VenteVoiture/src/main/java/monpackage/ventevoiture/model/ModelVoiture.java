package monpackage.ventevoiture.model;

import jakarta.persistence.*;


@Entity
@Table(name = "modele",schema = "public")
public class ModelVoiture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idModele;
    @Column(name = "nom_modele")
    private String nomModel;

    // Constructors, getters, and setters
    public ModelVoiture() {
    }

    public int getIdModele() {
        return idModele;
    }

    public void setIdModele(int idModele) {
        this.idModele = idModele;
    }

    public String getNomModel() {
        return nomModel;
    }

    public void setNomModel(String nomModel) {
        this.nomModel = nomModel;
    }
}
