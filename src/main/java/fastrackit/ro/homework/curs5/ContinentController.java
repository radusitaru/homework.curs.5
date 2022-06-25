package fastrackit.ro.homework.curs5;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.crypto.Cipher;
import java.util.List;

@RequestMapping("Continents")
@RestController
public class ContinentController {


    private final ContinentService continentService;
    private final ContinentRepository continentRepository;

    public ContinentController(ContinentService continentService, ContinentRepository continentRepository) {
        this.continentService = continentService;
        this.continentRepository = continentRepository;
    }

    @GetMapping({""})
    List<Continent> listContinents() {
        return continentRepository.findAll();
    }

    @GetMapping({"name/{continentName}"})
    Continent continentByName(@PathVariable String continentName) {
        return continentRepository.findAll().stream()
                .filter(Continent -> Continent.getName().equalsIgnoreCase(continentName))
                .findFirst()
                .orElseThrow();
    }

    @GetMapping({"id/{id}"})
    Continent continentById(@PathVariable int id) {
        return continentRepository.findById(id).stream()
                .findFirst()
                .orElseThrow();
    }



}
