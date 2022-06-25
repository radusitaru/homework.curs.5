package fastrackit.ro.homework.curs5;

import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

@Service
public class CountryReader {

static List<Country> countryList;

    //overload
    public List<Country> readCountries(String name) {
        if(name==null) {
            try {
                return Files.lines(Path.of("C:\\Users\\radus\\OneDrive\\Desktop\\FastTrackIT\\[JFS2] Java + Angular\\Lab 5\\homework.curs.5\\homework.curs.5\\countries.txt"))
                        .map(this::toCountry)
                        .toList();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        else{
            try {
                return Files.lines(Path.of("C:\\Users\\radus\\OneDrive\\Desktop\\FastTrackIT\\[JFS2] Java + Angular\\Lab 5\\homework.curs.5\\homework.curs.5\\countries.txt"))
                        .map(this::toCountry)
                        .filter(Country -> Country.getName().equalsIgnoreCase(name))
                        .toList();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    //overload
    public List<Country> readCountries() {
        try {
            return countryList = Files.lines(Path.of("C:\\Users\\radus\\OneDrive\\Desktop\\FastTrackIT\\[JFS2] Java + Angular\\Lab 5\\homework.curs.5\\homework.curs.5\\countries.txt"))
                    .map(this::toCountry)
                    .toList();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    private Country toCountry(String line) {
        String[] tokens = line.split("\\|");
        return new Country(tokens[0],tokens[1],Long.parseLong(tokens[2]),Long.parseLong(tokens[3]),tokens[4]);

    }


}
