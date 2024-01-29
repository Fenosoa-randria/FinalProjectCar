package monpackage.ventevoiture.Repository;

import monpackage.ventevoiture.model.AdminDemandeAnnonce;
import monpackage.ventevoiture.model.ProprietaireVoitureView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AdminDemandeRepository extends JpaRepository<AdminDemandeAnnonce,Integer> {
        List<AdminDemandeAnnonce> findAll();
        List<AdminDemandeAnnonce> findAllByIdVoiture(int id);
}
