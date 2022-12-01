package com.yourgoods.retailerservicejava.service;

import com.yourgoods.retailerservicejava.VO.RetailerLogin;
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

    //RETAILER REGISTRAION
    public Retailer saveRetailer(Retailer retailer) {
        List<Retailer> retailers = getAllRetailers();
        for(Retailer re : retailers){
            if(re.getRetailerEmail().equals(retailer.getRetailerEmail())){
                System.out.println("Email Already Exists! ");
                return null;
            }
        }

        return retailerRepository.save(retailer);
    }
    // LOG IN
    public Retailer validateRetailer(Retailer retailer) {
        List<Retailer> retailers = getAllRetailers();
        for(Retailer re : retailers){
            if(re.getRetailerEmail().equals(retailer.getRetailerEmail()) && re.getRetailerPassword().equals(retailer.getRetailerPassword())){
                System.out.println("Login Successfully");
                //System.out.println(re);
                return re;
            }
        }
        System.out.println("Please Register! No Email Found!! ");
        return null;
    }


}
