package fastrackit.ro.homework.curs5;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@org.springframework.stereotype.Service
public class ContinentService {

    Set<String> createContinentNameList() {
        Set<String> continentNameList = new HashSet<>();
        CountryReader.countryList.stream()
                .map(country -> country.getContinent())
                .forEach(String -> continentNameList.add(String));
        return continentNameList;
    }

     List<Continent> createContinents() {
        return createContinentNameList().stream()
                .map(String -> createContinent(String))
                .toList();

    }

    private Continent createContinent(String continentName) {
        return new Continent(continentName, CountryService.assignCountries(continentName));
    }
}
