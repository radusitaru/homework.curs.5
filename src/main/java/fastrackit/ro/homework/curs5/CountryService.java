package fastrackit.ro.homework.curs5;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {


    public static String assignCountries(String continentName) {
        return CountryReader.countryList.stream()
                .filter(Country -> Country.getContinent().equalsIgnoreCase(continentName))
                .map(Country -> Country.getName())
                .toList()
                .toString();
    }

    public List<Country> filterByPopulation(int min, int max, List<Country> countryList) {
        return countryList.stream()
                .filter(Country -> Country.getPopulation() > min)
                .filter(Country -> Country.getPopulation() < max)
                .toList();
    }

}
