package fastrackit.ro.homework.curs5;


import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "countries")
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@Builder
public class Country {

    Country(String name, String capitalCity, long population, long area, String continent){
        this(0,name,capitalCity,population,area,continent);
    }

    @Id
    @GeneratedValue
    private int id;

    private String name;
    private String capitalCity;
    private long population;
    private long area;
    private String continent;


}