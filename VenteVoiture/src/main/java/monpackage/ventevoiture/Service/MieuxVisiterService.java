package monpackage.ventevoiture.Service;

import monpackage.ventevoiture.Repository.MieuxVisiterRepository;
import monpackage.ventevoiture.model.MieuxVisiter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MieuxVisiterService {
    @Autowired
    MieuxVisiterRepository mieuxVisiterRepository;
    public List<MieuxVisiter> selectAllMieuxVisite(){return  mieuxVisiterRepository.findAll();}
}
