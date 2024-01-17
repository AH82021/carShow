package com.binary.carShow.service;

import com.binary.carShow.entity.Owner;
import com.binary.carShow.repository.OwnerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OwnerServiceImpl implements OwnerService{

    private final OwnerRepository ownerRepository;

    public OwnerServiceImpl(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }


    @Override
    public List<Owner> getOwners() {
        return ownerRepository.findAll();
    }
}
