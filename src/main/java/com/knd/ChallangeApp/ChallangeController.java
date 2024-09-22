package com.knd.ChallangeApp;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@RestController
@RequestMapping("/challenges/")
public class ChallangeController {

    private ChallengeServices challengeServices;

    public  ChallangeController(ChallengeServices challengeServices)
    {
        this.challengeServices= challengeServices;
    }
    @GetMapping("get")
    public ResponseEntity<List<Challange>> GetAllChallenges(){
        return new ResponseEntity<>(challengeServices.GetAllChallenges(),HttpStatus.OK);
    }
    @PostMapping("add")
    public ResponseEntity<String> addChallange(@RequestBody Challange challange){
         boolean isChallengeAdded = challengeServices.addChallange(challange);
         if(isChallengeAdded)
         {
             return new ResponseEntity<>("Challenge added successfully",HttpStatus.OK);
         }
         else {
             return new ResponseEntity<>("Challenge not added successfully",HttpStatus.NOT_FOUND);
         }

    }
    @GetMapping("{month}")
    public ResponseEntity<Challange> getChanllange(@PathVariable  String month)
    {

        Challange challange =challengeServices.getChallange(month);
        if(challange != null)
        {
            return new ResponseEntity<>(challange, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @PutMapping("{id}")
    public  ResponseEntity<String> UpdateChallange(@PathVariable Long id,@RequestBody Challange updatedChallange)
    {
       boolean isChallangeUpdated= challengeServices.updateChallange(id,updatedChallange);
       if(isChallangeUpdated)
       {
           return  new ResponseEntity<>("Challange Updated successfully",HttpStatus.OK);
       }
       else {
           return  new ResponseEntity<>("Challange Not Updated successfully",HttpStatus.NOT_FOUND);

       }
    }
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteChallange(@PathVariable  Long id)
    {
      boolean isDeleted=  challengeServices.DeleteChallange(id);
      if(isDeleted)
      {
          return new ResponseEntity<>("Challange Deleted successfully",HttpStatus.OK);
      }
      else {
          return  new ResponseEntity<>("Challange Not Deleted successfully",HttpStatus.NOT_FOUND);
      }
    }
}
