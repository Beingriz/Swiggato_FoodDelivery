package com.example.Swiggato.repisoory;

import com.example.Swiggato.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
   public Customer findByPhoneNo(String mobile);
}
