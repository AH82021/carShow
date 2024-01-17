package com.binary.carShow.web;

import com.binary.carShow.entity.Owner;
import com.binary.carShow.service.OwnerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/owner")
public class OwnerController {
    private final OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }
@GetMapping("/owners")
    public ResponseEntity<List<Owner>> getOwners(){
        return new ResponseEntity<>(ownerService.getOwners(), HttpStatus.OK);
    }

}
