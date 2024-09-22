package com.knd.ChallangeApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ChallengeServices {
   // private List<Challange> challenges= new ArrayList<>(); //arrays to store

    private Long nextId=1L;
 @Autowired
 ChallengeRepository challengeRepository;
    public  ChallengeServices(){

    }
    public List<Challange> GetAllChallenges(){
        return challengeRepository.findAll();
    }
    public boolean addChallange(Challange challange){
        if(challange != null)

        {
            challange.setId(nextId++);
            challengeRepository.save(challange);
            return true;
        }
        else {
            return  false;
        }



    }
    public Challange getChallange(String month)
    {
       Optional<Challange> challange= challengeRepository.findByMonthIgnoreCase(month);


        return  challange.orElse(null);
    }
    public boolean updateChallange(Long id,Challange updatedChallange)
    {
        Optional<Challange> challange=   challengeRepository.findById(id);
        if(challange.isPresent())
        {
            Challange challengeToUpdate= challange.get();
            challengeToUpdate.setMonth(updatedChallange.getMonth());
            challengeToUpdate.setDescription(updatedChallange.getDescription());
            challengeRepository.save(challengeToUpdate);
            return  true;
        }else {
            return  false;
        }



    }
    public  boolean DeleteChallange(Long id)
    {
        Optional<Challange> challange=   challengeRepository.findById(id);
        if(challange.isPresent())
        {
            challengeRepository.deleteById(id);
            return true;
        }
        else {
            return false;
        }

    }
}
