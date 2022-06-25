package fastrackit.ro.homework.curs5;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {

        SpringApplication.run(Application.class, args);
    }

    CountryReader countryReader = new CountryReader();
    ContinentService continentService = new ContinentService();

    @Bean
    CommandLineRunner atStartup(CountryRepository countryRepository, ContinentRepository continentRepository) {
        return args -> {
            countryRepository.saveAll(countryReader.readCountries());
            continentRepository.saveAll(continentService.createContinents());
        };
    }
}
