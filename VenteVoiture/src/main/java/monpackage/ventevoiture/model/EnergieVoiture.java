package monpackage.ventevoiture.model;

import jakarta.persistence.*;

@Entity
@Table(name = "energie",schema = "public")
public class EnergieVoiture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEnergie;
    @Column(name = "nom_energie")
    private String nomEnergie;

    // Constructors, getters, and setters
    public EnergieVoiture() {
    }

    public EnergieVoiture(int idEnergie, String nomEnergie) {
        this.idEnergie = idEnergie;
        this.nomEnergie = nomEnergie;
    }

    public int getIdEnergie() {
        return idEnergie;
    }

    public void setIdEnergie(int idEnergie) {
        this.idEnergie = idEnergie;
    }

    public String getNomEnergie() {
        return nomEnergie;
    }

    public void setNomEnergie(String nomEnergie) {
        this.nomEnergie = nomEnergie;
    }
}
