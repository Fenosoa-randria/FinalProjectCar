package monpackage.ventevoiture.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "type_vitesse",schema = "public")
public class TransmissionVoiture {
    @Id
    int id_type_vitesse;
    @Column(name = "nom_type")
    String nom_type;

    public int getId_type_vitesse() {
        return id_type_vitesse;
    }

    public void setId_type_vitesse(int id_type_vitesse) {
        this.id_type_vitesse = id_type_vitesse;
    }

    public String getNom_type() {
        return nom_type;
    }

    public void setNom_type(String nom_type) {
        this.nom_type = nom_type;
    }
}
