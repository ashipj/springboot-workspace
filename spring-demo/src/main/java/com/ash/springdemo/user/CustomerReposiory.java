package com.ash.springdemo.user;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerReposiory extends CrudRepository<Customer, Long> {

    public Customer findByEmail(String email);
}
