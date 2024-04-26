package com.example.military_management_syetem.service;

import java.util.List;
import org.springframework.data.domain.Pageable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.example.military_management_syetem.model.Basecamp;
import com.example.military_management_syetem.repository.BasecampRepository;

@Service
public class BasecampService {

    @Autowired
    private BasecampRepository basecampRepository;

    // Basecamp operations
    public Basecamp saveBasecamp(Basecamp basecamp) {
        return basecampRepository.save(basecamp);
    }

    public List<Basecamp> saveBasecamp(List<Basecamp> basecamp) {
        return basecampRepository.saveAll(basecamp);
    }

    public List<Basecamp> getBasecamps() {
        return basecampRepository.findAll();
    }

    public Basecamp getBasecamp(Long id) {
        return basecampRepository.findById(id).orElse(null);
    }

    public void deleteBasecamp(Long id) {
        basecampRepository.deleteById(id);
    }

    // public List<Basecamp> pageNation(int pageno , int size)
    // {
    //     return basecampRepository.findAll()
    // }

    // public List<Basecamp> pageBasecamp(int pn,int sz,String name)
    // {
    //     List<Basecamp> pg = basecampRepository.findAll(Sort.by(Direction.DESC, name)) ;
    //     return pg;
    // }

    public List<Basecamp> getSorted(String field)
    {
        return basecampRepository.findAll(Sort.by(field));
    }
    public List<Basecamp> getPagination(int offset,int size)
    {
        return basecampRepository.findAll(PageRequest.of(offset, size)).getContent();
                        
    }
    public List<Basecamp> getSortedPagination(int offset,int size,String field)
    {
        return basecampRepository.findAll(PageRequest.of(offset, size, Sort.by(field))).getContent();
    }

    public List<Basecamp> getbyLocation(String loc)
    {
        return basecampRepository.findBylocation(loc);
    }

    public Basecamp getbyquery(double a,double b) {
        return basecampRepository.findByLatLon(a,b);
    }

    public List<Basecamp> getPaginationforonetomany(int offset,int size)
    {
        return basecampRepository.findAll(PageRequest.of(offset, size)).getContent();
                        
    }

    
    
}
