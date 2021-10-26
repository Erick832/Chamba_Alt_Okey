package com.example.demo.services;

import com.example.demo.entities.Ability;
import com.example.demo.repositories.AbilityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AbilityServices {
    @Autowired
    private AbilityRepository abilityRepository;
    public Ability createAbility(String textAbility){
        Ability ability=new Ability();
        ability.setAbility(textAbility);
        return abilityRepository.save(ability);
    }
}
