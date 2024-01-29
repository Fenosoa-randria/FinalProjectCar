package monpackage.ventevoiture.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;

@Entity
@IdClass(AdminStatistiqueId.class)
public class AdminStatistique {
    @Id
    @Column(name = "nombre")
    int nombre;

    @Id
    @Column(name = "marque")
    String marque;

    @Id
    @Column(name = "annee")
    String annee;
    public String getAnnee() {
        return annee;
    }

    public void setAnnee(String annee) {
        this.annee = annee;
    }

    public int getNombre() {
        return nombre;
    }

    public void setNombre(int nombre) {
        this.nombre = nombre;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }
}
