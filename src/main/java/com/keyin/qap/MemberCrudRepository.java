package com.keyin.qap;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//interface which will extend built in crud repository
//a link in the chain if u will
@Repository
public interface MemberCrudRepository
        extends CrudRepository<Member, Long> {

}
