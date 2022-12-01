package com.yourgoods.retailerservicejava.controller;

import com.yourgoods.retailerservicejava.VO.RetailerLogin;
import com.yourgoods.retailerservicejava.models.Retailer;
import com.yourgoods.retailerservicejava.service.RetailerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/retailer")
public class RetailerController {
    private RetailerService retailerService;

    @Autowired
    public RetailerController(RetailerService retailerService) {
        this.retailerService = retailerService;
    }

    @PostMapping("/")
    public Retailer registerRetailer(@RequestBody Retailer retailer){
        return retailerService.registerRetailer(retailer);
    }

    @GetMapping("/")
    public List<Retailer> getAllRetailers(){
        return retailerService.getAllRetailers();
    }

    @GetMapping("/{id}")
    public Retailer getRetailerById(@PathVariable("id") String retailerId){
        return retailerService.getRetailerById(retailerId);
    }

    @DeleteMapping("/{id}")
    public Boolean deleteRetailerById(@PathVariable("id") String retailerId){
        return retailerService.deleteRetailerById(retailerId);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Retailer> updateRetailerDetails(@PathVariable("id") String retailerId, @RequestBody Retailer retailer){
        return retailerService.updateRetailerDetails(retailerId, retailer);
    }

    @PostMapping("/validateRetailer")
    public Retailer validateRetailer(@RequestBody Retailer retailer){
        return retailerService.validateRetailer(retailer);
    }



}
