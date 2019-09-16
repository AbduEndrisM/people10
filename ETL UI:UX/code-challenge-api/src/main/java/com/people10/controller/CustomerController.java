package com.people10.controller;

import com.people10.JsonResponse;
import com.people10.domain.Customer;
import com.people10.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class CustomerController {

    @Autowired
    private CustomerService customerService;


    @GetMapping("/")
    public String getHomePage() {
        return "Home Sweet Home :)";
    }


    @GetMapping("/customers")
    public List<Customer> findAllCustomers() {
        return customerService.findAllCustormer();
    }


    @PostMapping("/customers/upload")
    public String uploadFile(MultipartHttpServletRequest request) throws IOException {

        Iterator<String> iterator = request.getFileNames();
        MultipartFile file = request.getFile(iterator.next());
        customerService.upload(file);
        return "Successful";
    }


    @PostMapping("/customers")
    public ResponseEntity<String> saveCustomer(@RequestBody Customer customer) {
        return customerService.saveCustormer(customer);
    }


    @GetMapping("/customers/{id}")
    public Customer findCustomer(@PathVariable Long id) {
        return customerService.findCustormer(id);
    }


    @DeleteMapping("/customers/{id}")
    public ResponseEntity<JsonResponse> deleteCustomer(@PathVariable Long id) {
        return customerService.deleteCustormer(id);
    }


    @PutMapping("/customers")
    public ResponseEntity<String> updateCustomer(@RequestBody Customer customer) {
        return customerService.updateCustormer(customer);
    }


}
