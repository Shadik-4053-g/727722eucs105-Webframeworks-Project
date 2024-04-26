package com.example.military_management_syetem.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Basecamp 
{
    @Id
    private Long basecampid;
    private String basecampname;
    private String location;
    private int capacity;
    private double latitude;
    private double longitude;
    private String terrain;     

    // @OneToOne( mappedBy = "basecamp" , cascade = CascadeType.ALL)
    // private Weapon weapon;

     @OneToMany( mappedBy = "basecamp" , cascade = CascadeType.ALL)
     @JsonManagedReference
     private List<Weapon> weapons;

     public List<Weapon> getWeapons() {
        if (weapons == null) {
            return null;
        }
        return weapons.size() > 2 ? weapons.subList(0, 2) : weapons;
    }
}
