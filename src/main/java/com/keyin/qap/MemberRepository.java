package com.keyin.qap;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "member", path = "member")
public interface  MemberRepository extends JpaRepository<Member, Long>{

    //query to find member by last name from the list of Member object
    //using last_name instance variable from Member class
    public List<Member> findByLastName(@Param("last_name")String lastName);
    //query to find member by first name from the list of Member object
    //using first_name instance variable from Member class
    public List<Member> findByFirstName(@Param("first_name")String firstName);
    //query to find member by first and last name from list of Member object
    //uses first_name and last_name instance variables from Member class
    public List<Member> findByFirstNameAndLastName(@Param("first_name")String firstName,
                                                   @Param("last_name")String lastName);

}
