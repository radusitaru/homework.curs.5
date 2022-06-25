package fastrackit.ro.homework.curs5;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Countries")
public class CountryController {

    private final CountryService countryService;
    private final CountryRepository countryRepository;

    public CountryController(CountryService countryService, CountryRepository countryRepository) {
        this.countryService = countryService;
        this.countryRepository = countryRepository;
    }

    @GetMapping({""})
    List<Country> listCountryObjects() {
        return countryRepository.findAll();
    }

    @GetMapping({"names"})
    List<String> listCountryNames() {
        return countryRepository.findAll().stream()
                .map(Country -> Country.getName())
                .toList();
    }

    @GetMapping({"{id}"})
    Country country(@PathVariable int id) {
        return countryRepository.findById(id).stream()
                .findFirst()
                .orElseThrow();
    }

    @GetMapping({"{id}/Capital"})
    String capitalCity(@PathVariable int id) {
        return countryRepository.findById(id)
                .stream().findFirst()
                .map(Country::getCapitalCity)
                .orElseThrow();
    }

    @GetMapping({"{id}/Population"})
    long population(@PathVariable int id) {
        return countryRepository.findById(id)
                .stream().findFirst()
                .map(Country::getPopulation)
                .orElseThrow();
    }

    @GetMapping("filterByPopulation")
    List<Country> minPopulation(@RequestParam int min,
                                @RequestParam int max) {
        return countryService.filterByPopulation(min, max, countryRepository.findAll());
    }
}
