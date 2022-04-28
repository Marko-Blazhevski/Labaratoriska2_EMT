package mk.ukim.finki.labaratoriska2_emt.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class Country {

    public Country () {

    }

    public Country(String name, String continent) {
        this.name = name;
        this.continent = continent;
    }

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String continent;

}