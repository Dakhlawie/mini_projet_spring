package com.meriem.demo.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.meriem.demo.entities.Chantier;
import com.meriem.demo.repos.ChantierRepository;

@RestController
@RequestMapping("/api/ch")
@CrossOrigin
public class ChantierRestController {
@Autowired
ChantierRepository chantierRepository;
@RequestMapping(method=RequestMethod.GET)
public List<Chantier> getAllChantiers()
{
return chantierRepository.findAll();
}
@RequestMapping(value="/{id}",method = RequestMethod.GET)
public Chantier getChantierById(@PathVariable("id") Long id) {
return chantierRepository.findById(id).get();
}

}
