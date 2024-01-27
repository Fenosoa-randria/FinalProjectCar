package monpackage.ventevoiture.Service;

import monpackage.ventevoiture.Repository.PhotoVoitureRepository;
import monpackage.ventevoiture.model.PhotoVoiture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhotoVoitureService {
    @Autowired
    PhotoVoitureRepository photoVoitureRepository;
    public List<PhotoVoiture> selectAllPhoto(){
        return photoVoitureRepository.findAll();
    }
    public  void insererPhoto(PhotoVoiture p){
        photoVoitureRepository.save(p);
    }
}
