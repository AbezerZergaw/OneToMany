package com.example.demo;


import javax.persistence.*;
import java.util.Set;


@Entity
public class Person {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;


    @OneToMany
    private Set<Pet> pets;

    public Person() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Pet> getPets() {
        return pets;
    }

    public void setPets(Set<Pet> pests) {
        this.pets = pests;
    }

    public void AddPet(Pet pet){

        pets.add(pet);
    }
}

