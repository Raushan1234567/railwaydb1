package com.c3ihub.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.c3ihub.model.Dog;
import com.c3ihub.service.DserviceInterface;

@RestController
public class Dcontroller {

	@Autowired
	private DserviceInterface dserviceInterace;
	
	@PostMapping("/dogs")
	public ResponseEntity<Dog> addDog(@RequestBody Dog dog){
		return new ResponseEntity<Dog>(dserviceInterace.addDog(dog),HttpStatus.CREATED);
		
	}
	
	
	@GetMapping("/dogs")
	public ResponseEntity<String> getDog(@RequestParam String dogName){
		return new ResponseEntity<String>(dserviceInterace.getDog(dogName),HttpStatus.OK);
		
	}

	
	@GetMapping("/allDogs")
	public ResponseEntity<List<Dog>> getAllDog(){
		return new ResponseEntity<List<Dog>>(dserviceInterace.getAllDog(),HttpStatus.OK);
		
	}
	
	@DeleteMapping("/deleteAllDogs")
	public ResponseEntity<String> deleteAll(){
		return new ResponseEntity<String>(dserviceInterace.deleteAll(),HttpStatus.OK);
		
	}
	@DeleteMapping("/deleteDogs")
	public ResponseEntity<String> delete(@RequestParam String dogName){
		return new ResponseEntity<String>(dserviceInterace.delete(dogName),HttpStatus.OK);
		
	}
	
	@PatchMapping("/updatesDogDetails/{dog_uniqueid}")
	public ResponseEntity<Dog> update(@RequestParam Integer dog_uniqueid,String name,String nature,String breed){
		
		return new ResponseEntity<Dog>(dserviceInterace.update(dog_uniqueid,name,nature,breed),HttpStatus.OK);
	}
	
}
