package pjatk.adrwoj.jazs16095nbp.Service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pjatk.adrwoj.jazs16095nbp.Model.RootList;
import pjatk.adrwoj.jazs16095nbp.Repository.NBPRepository;
import pjatk.adrwoj.jazs16095nbp.Model.NBP;
import pjatk.adrwoj.jazs16095nbp.Model.Root;

@Service
public class NBPService {

    private final NBPRepository nbpRepository;
    private final RestTemplate restTemplate;

    public NBPService(NBPRepository nbpRepository, RestTemplate restTemplate) {
        this.nbpRepository = nbpRepository;
        this.restTemplate = restTemplate;
    }


    public Double getPrice(String start, String end){
        String url = "http://api.nbp.pl/api/cenyzlota/" + start + "/" + end +"/";
        Root[] roots = restTemplate.getForObject(url, Root[].class);

        return calculateRate(roots);
    }

    public NBP save(NBP nbp){
        return nbpRepository.save(nbp);
    }

    private double calculateRate(Root[] rootList){
        double rate = 0.00;
        for (Root root: rootList
             ) {
            rate = rate + root.getCena();
        }

        return rate / rootList.length;
    }

}
