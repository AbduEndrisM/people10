package com.people10.service;

import com.people10.JsonResponse;
import com.people10.domain.Customer;
import com.people10.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;


    public ResponseEntity<String> saveCustormer(Customer customer) {
         customerRepository.save(customer);
        return new ResponseEntity<>("Customer Saved", HttpStatus.CREATED);
    }


    public List<Customer> findAllCustormer() {
        List<Customer> customerList = new ArrayList<>();
        customerRepository.findAll().forEach(customerList::add);
        return customerList;
    }

    public Customer findCustormer(Long id) {
//        Customer customer = customerRepository.findAll().stream().findFirst().get();
        return customerRepository.findById(id).orElse(null);
    }

    public ResponseEntity<JsonResponse> deleteCustormer(Long id) {
        System.out.println("Delete Customer with Id  " + id);
        customerRepository.deleteById(id);
        Customer customer = findCustormer(id);
        JsonResponse<Customer> response = new JsonResponse<>("Customer has been deleted", customer);
        return new ResponseEntity<>(response, HttpStatus.OK);

    }

    public ResponseEntity<String> updateCustormer(Customer customer) {
        customerRepository.save(customer);
        return new ResponseEntity<>("Customer has been updated", HttpStatus.OK);

    }




}
