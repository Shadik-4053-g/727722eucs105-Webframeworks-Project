package com.example.military_management_syetem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.military_management_syetem.model.Basecamp;
import com.example.military_management_syetem.service.BasecampService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BasecampController {

    @Autowired
    private BasecampService basecampService;

    // Basecamp operations
    @GetMapping("/basecamps")
    public List<Basecamp> getBasecamps() {
        return basecampService.getBasecamps();
    }
   

    @GetMapping("/basecamp/{id}")
    public Basecamp getBasecamp(@PathVariable Long id) {
        return basecampService.getBasecamp(id);
    }

    @PostMapping("/basecamp/post")
    @ResponseStatus( value = HttpStatus.UPGRADE_REQUIRED)
    public ResponseEntity<Basecamp> saveBasecamp(@RequestBody Basecamp basecamp) {
        // String h = basecamp.getWeapon().getType();
        // Weapon p = new Weapon(); // ans 

        // basecamp.setWeapon(p);


        // ///

        return new ResponseEntity<>(basecampService.saveBasecamp(basecamp),HttpStatus.CREATED);
    }
    @PutMapping("/basecamp/{id}")
    public String updateBasecamp(@PathVariable Long id, @RequestBody Basecamp updatedBasecamp) {
        Basecamp existingBasecamp = basecampService.getBasecamp(id);
        if (existingBasecamp != null) {
            existingBasecamp.setLocation(updatedBasecamp.getLocation());
            existingBasecamp.setCapacity(updatedBasecamp.getCapacity());
            existingBasecamp.setLatitude(updatedBasecamp.getLatitude());
            existingBasecamp.setLongitude(updatedBasecamp.getLongitude());
            
            basecampService.saveBasecamp(existingBasecamp);
            
            return "Basecamp Updated (excluding name and terrain)";
        } else {
            return "Basecamp Not Found";
        }
    }

    @DeleteMapping("/basecamp/{id}")
    public String deleteBasecamp(@PathVariable Long id) {
        Basecamp existingBasecamp = basecampService.getBasecamp(id);
        if (existingBasecamp != null) {
            basecampService.deleteBasecamp(id);
            return "Deleted";
        } else {
            return "No Data Found";
        }
    }

    
    @GetMapping("/sortBy/{field}")
    public ResponseEntity<List<Basecamp>> getMethodName(@PathVariable("field") String field) {
        List<Basecamp> list = basecampService.getSorted(field);
        if(list.size() == 0)
        {
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(list,HttpStatus.OK);
    }
    
    @GetMapping("/page/{offset}/{pagesize}")
    public ResponseEntity<List<Basecamp>> getMethodName(@PathVariable("offset") int offset,@PathVariable("pagesize") int size) {
        List<Basecamp> list = basecampService.getPagination(offset,size);
        if(list.size() == 0)
        {
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(list,HttpStatus.OK);
    }
    
    @GetMapping("/pagesort/{offset}/{pagesize}/{field}")
    public ResponseEntity<List<Basecamp>> getSortedPagination(@PathVariable("offset") int offset,@PathVariable("pagesize") int size,@PathVariable("field") String field) {
        List<Basecamp> list = basecampService.getSortedPagination(offset,size,field);
        if(list.size() == 0)
        {
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(list,HttpStatus.OK);
    }


    @GetMapping("/location/{loc}")
    public ResponseEntity<List<Basecamp>> getbyLoc(@PathVariable("loc") String loc) {
        List<Basecamp> li = basecampService.getbyLocation(loc);
        if (!li.isEmpty()) {
            return new ResponseEntity<>(li, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @GetMapping("/atquery/{lat}/{lon}")
    public ResponseEntity<Basecamp> getlatlon(@PathVariable double lat,@PathVariable double lon) {
        Basecamp li = basecampService.getbyquery(lat,lon);
        if (li != null) {
            return new ResponseEntity<>(li, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @GetMapping("/pageonetomany/{offset}/{pagesize}")
    public ResponseEntity<List<Basecamp>> getMethodName1(@PathVariable("offset") int offset,@PathVariable("pagesize") int size) {
        List<Basecamp> list = basecampService.getPaginationforonetomany(offset,size);
        if(list.size() == 0)
        {
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(list,HttpStatus.OK);
    }


   
}
