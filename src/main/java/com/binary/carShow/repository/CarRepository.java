package com.binary.carShow.repository;

import com.binary.carShow.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository  extends CrudRepository<Car,Long> {
    // Jpa , Crud  , List ,Paganination
// Rest (Representational State Transfer)
    // is an architectural style for crete web services.
    // six constraints
    // Stateless : The server does not hold any information about the client state
    // Client  and server :
    // Cacheable :
    // Uniform Interface:
    //Layered System:
    // Code on Demand Option
    //     getAllCarByMake(String make);






}
