package fastrackit.ro.homework.curs5;


import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "continents")
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@Builder
public class Continent {

    Continent(String name, String countryList){
        this(0,name,countryList);
    }

    @Id
    @GeneratedValue
    private int id;
    private String name;
    @Column(name = "countryList", length = 5000)
    private String countryList;



}
