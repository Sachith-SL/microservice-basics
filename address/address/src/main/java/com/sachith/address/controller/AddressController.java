package com.sachith.address.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/addresses")
public class AddressController {

    @GetMapping()
    public ResponseEntity<String> getAddress(){
        return ResponseEntity.ok("Rathna, Eleboda, Gintota");
    }
}
