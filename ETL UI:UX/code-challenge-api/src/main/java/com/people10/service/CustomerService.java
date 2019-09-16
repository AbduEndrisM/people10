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

    public boolean upload(MultipartFile file) {

        if (file == null || file.isEmpty()) {
            return false;
        }

        try {
            String fileName = file.getOriginalFilename();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(file.getInputStream()));
            String line;


            Customer customer;
            List<Customer> customerList = new ArrayList<>();
            DateFormat df = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");

            if (fileName.equals("data1.csv")) {
                bufferedReader.readLine();
                while ((line = bufferedReader.readLine()) != null ) {

                    String[] data = line.split(",");
                    customer = new Customer();
                    Date createdAt;
                    try {
                        createdAt = (Date) df.parse(data[0]);
                    } catch (Exception e) {
                        createdAt = new Date();
                    }
                    customer.setCreatedAt(createdAt);
                    customer.setFirstName(data[1]);
                    customer.setLastName(data[2]);
                    customer.setEmail(data[3]);
                    try {
                        customer.setLatitude(Float.parseFloat(data[4]));
                        customer.setLongitude(Float.parseFloat(data[5]));
                    } catch (Exception e) {
                        customer.setLatitude(0f);
                        customer.setLongitude(0f);
                    }
                    customer.setIp(data[6]);
                    customerList.add(customer);
                }
                save(customerList);

            } else if (fileName.equals("data2.csv")) {
                bufferedReader.readLine();
                while ((line = bufferedReader.readLine()) != null) {

                    String[] data = line.split(",");
                    customer = new Customer();
                    Date createdAt;
                    try {
                        createdAt = (Date) df.parse(data[0]);
                    } catch (Exception e) {
                        createdAt = new Date();
                    }
                    customer.setCreatedAt(createdAt);
                    customer.setIp(data[1]);
                    try {
                        customer.setLatitude(Float.parseFloat(data[2]));
                        customer.setLongitude(Float.parseFloat(data[3]));
                    } catch (Exception e) {
                        customer.setLatitude(0f);
                        customer.setLongitude(0f);
                    }
                    customer.setFirstName(data[4]);
                    customer.setLastName(data[5]);
                    customer.setEmail(data[6]);
                    customerList.add(customer);

                }
                save(customerList);
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public void save(List<Customer> customers) {

        for (Customer customer : customers) {
            customerRepository.save(customer);
        }

    }



}
