package com.keyin.qap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
public class TournamentController extends Member{
    @Autowired
    private TournamentCrudRepository crudRepo;

    @GetMapping("/tournaments")
    public List<Tournament> getAllTournaments() {
        return (List<Tournament>) crudRepo.findAll();
    }

    @PostMapping("/tournament")
    public void createTournament(@RequestBody Tournament tournament){
        crudRepo.save(tournament);
    }

    @PutMapping("/tournament/{id}")
    public void updateTournament(@PathVariable String id, @RequestBody Tournament tournament, HttpServletResponse response){
        Optional<Tournament> returnValue = crudRepo.findById(Long.parseLong(id));
        Tournament tournamentToUpdate = null;

        if(returnValue.isPresent()){
            tournamentToUpdate = returnValue.get();
            tournamentToUpdate.setName(tournament.getName());

            crudRepo.save(tournamentToUpdate);
        } else{
            try{
                response.sendError(
                        404, "Tournament with id: " +tournament.getId()
                                + " not found." );
            } catch(IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
    @DeleteMapping("/tournament/{id}")
    public void deleteTournament(@PathVariable Long id) {

        crudRepo.deleteById(id);
    }

}



