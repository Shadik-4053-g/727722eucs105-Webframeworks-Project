package com.example.military_management_syetem.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Weapon 
{
    @Id
    private Long weapon_id;
    private String weapon_name;
    private String type;
    private String caliber;
    private String manufacturer;
    private double weight; // in kilograms
    private int quantity;

    // @OneToOne
    // private Basecamp basecamp;
    

    @JsonBackReference
    @ManyToOne
    private Basecamp basecamp;


}
