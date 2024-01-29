package monpackage.ventevoiture.Service;

import monpackage.ventevoiture.Repository.TransmissionVoitureRepository;
import monpackage.ventevoiture.model.TransmissionVoiture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransmissionVoitureService {
    @Autowired
    TransmissionVoitureRepository transmissionVoitureRepository;
    public List<TransmissionVoiture> selectAllTransmission(){return transmissionVoitureRepository.findAll();}
}
