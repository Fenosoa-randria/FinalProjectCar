package monpackage.ventevoiture.model;

import jakarta.persistence.*;
@Entity
@Table(name = "marque",schema = "public")
public class MarqueVoiture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idMarque;
    @Column(name = "nom_marque")
    private String nomMarque;

    // Constructors, getters, and setters
    public MarqueVoiture() {
    }

    public MarqueVoiture(int idMarque, String nomMarque) {
        this.idMarque = idMarque;
        this.nomMarque = nomMarque;
    }

    public int getIdMarque() {
        return idMarque;
    }

    public void setIdMarque(int idMarque) {
        this.idMarque = idMarque;
    }

    public String getNomMarque() {
        return nomMarque;
    }

    public void setNomMarque(String nomMarque) {
        this.nomMarque = nomMarque;
    }
}
