package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashSet;
import java.util.Set;

@Controller
public class MainController {


    @Autowired
    PersonRepository personRepository;

    @Autowired
    PetRepository petRepository;


    @RequestMapping("/")
    public String HomePage(Model model) {
        Set<Pet> pets = new HashSet<>();


        Person person = new Person();


        person.setName("Henna");

        personRepository.save(person);
        Pet pet = new Pet();
        pet.setPetName("cat");
        pet.setPerson(person);
        pets.add(pet);

        petRepository.save(pet);

        pet = new Pet();
        pet.setPetName("dog");
        pet.setPerson(person);
        pets.add(pet);



        person.setPets(pets);


        petRepository.save(pet);

        model.addAttribute("persons", personRepository.findAll());


        return "index";
    }


}
