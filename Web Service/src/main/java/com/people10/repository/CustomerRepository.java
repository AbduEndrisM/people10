package com.people10.repository;


import com.people10.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
