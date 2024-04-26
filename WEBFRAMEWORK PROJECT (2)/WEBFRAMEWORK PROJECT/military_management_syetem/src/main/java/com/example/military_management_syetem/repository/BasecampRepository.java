package com.example.military_management_syetem.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.military_management_syetem.model.Basecamp;

public interface BasecampRepository extends JpaRepository<Basecamp, Long> {
    
    List<Basecamp> findBylocation(String a);

    @Query("select v from Basecamp as v where v.latitude=?1 and v.longitude=?2")
    Basecamp findByLatLon(double a,double b);    


 

}
