package com.sachith.address.controller;

import com.sachith.address.model.Address;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/addresses")
public class AddressController {

    @GetMapping()
    public ResponseEntity<Address> getAddress(){
        return ResponseEntity.ok(new Address("Rathna, Eleboda, Gintota"));
    }
}
