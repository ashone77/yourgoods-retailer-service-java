package com.yourgoods.retailerservicejava.service;

import com.yourgoods.retailerservicejava.models.Retailer;
import com.yourgoods.retailerservicejava.repository.RetailerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RetailerService {
    private final RetailerRepository retailerRepository;

    @Autowired
    public RetailerService(RetailerRepository retailerRepository) {
        this.retailerRepository = retailerRepository;
    }

    public Retailer registerRetailer(Retailer retailer) {
        return retailerRepository.save(retailer);
    }


    public List<Retailer> getAllRetailers() {
        return retailerRepository.findAll();
    }

    public Retailer getRetailerById(String retailerId) {
        return retailerRepository.findByRetailerId(retailerId);
    }

    public Boolean deleteRetailerById(String retailerId) {
        return retailerRepository.deleteByRetailerId(retailerId);
    }

    public ResponseEntity<Retailer> updateRetailerDetails(String retailerId, Retailer retailer) {
        Optional<Retailer> retailerOptional = Optional.ofNullable(retailerRepository.findByRetailerId(retailerId));
        if(retailerOptional.isPresent()){
            Retailer _retailer = retailerOptional.get();
            _retailer.setRetailerName(retailer.getRetailerName());
            _retailer.setRetailerPhone(retailer.getRetailerPhone());
            _retailer.setRetailerAddress(retailer.getRetailerAddress());
            _retailer.setRetailerPassword(retailer.getRetailerPassword());
            _retailer.setRetailerPincode(retailer.getRetailerPincode());
            _retailer.setRetailerEmail(retailer.getRetailerEmail());
            return new ResponseEntity<>(retailerRepository.save(_retailer),HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }




}