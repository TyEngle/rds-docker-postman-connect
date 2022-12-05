package com.keyin.qap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
public class MemberController {
    @Autowired
    private MemberCrudRepository crudRepo;

    @GetMapping("/members")
    public List<Member> getAllMembers() {
        return (List<Member>) crudRepo.findAll();
    }

    @PostMapping("/member")
    public void createMember(@RequestBody Member member){
        crudRepo.save(member);
    }

    @PutMapping("/member/{id}")
    public void updateMember(@PathVariable String id, @RequestBody Member member, HttpServletResponse response){
    Optional<Member> returnValue = crudRepo.findById(Long.parseLong(id));
    Member memberToUpdate = null;

    if(returnValue.isPresent()){
        memberToUpdate = returnValue.get();
        memberToUpdate.setFullName(member.getFullName());

        crudRepo.save(memberToUpdate);
    } else{
        try{
            response.sendError(
                    404, "member with id: " +member.getId()
                            + " not found." );
        } catch(IOException e) {
            throw new RuntimeException(e);
        }
    }
    }

}
