package monpackage.ventevoiture.model;
import java.util.List;

public class ProposVoitureResponse {
    public List<CategorieVoiture> categories;
    public List<ModelVoiture> modeles;
    public List<EnergieVoiture> energies;
    public List<MarqueVoiture> marques;

    public List<MarqueVoiture> getMarques() {
        return marques;
    }

    public void setMarques(List<MarqueVoiture> marques) {
        this.marques = marques;
    }

    public List<CategorieVoiture> getCategories() {
        return categories;
    }

    public void setCategories(List<CategorieVoiture> categories) {
        this.categories = categories;
    }

    public List<ModelVoiture> getModeles() {
        return modeles;
    }

    public void setModeles(List<ModelVoiture> modeles) {
        this.modeles = modeles;
    }

    public List<EnergieVoiture> getEnergies() {
        return energies;
    }

    public void setEnergies(List<EnergieVoiture> energies) {
        this.energies = energies;
    }
}
