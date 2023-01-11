package fr.jeuxminicie.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.jeuxminicie.dtos.FavoriteDto;
import fr.jeuxminicie.exceptions.NotFoundException;
import fr.jeuxminicie.services.FavoriteService;

@RestController
@RequestMapping("api/favorites")
public class FavoriteController {
	
	
	@Autowired
	private FavoriteService service;
	
	
	@GetMapping(produces = "application/json")
	public List<FavoriteDto> getAllFavorites() throws Exception{	
		return service.getAll();
	}
	
	
	@GetMapping(value="/{id}", produces="application/json")
	public ResponseEntity<Object> getUserById(@PathVariable("id") long id) throws Exception { 	
		
		try {
			FavoriteDto result = service.getById(id);
			return ResponseEntity.status(HttpStatus.OK).body(result);
			
		}catch (NotFoundException e){
			
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
			
	}
	
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<String> deleteById(@PathVariable("id") long id) throws Exception{
		
		try {
			service.deleteById(id);
			return ResponseEntity.status(HttpStatus.OK).body("Successfully deleted user with id : " + id);
			
		}catch (NotFoundException e) {
			
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
		
	}
	
	
	@PostMapping(value="/create", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Object> createNewFavorite(@RequestBody FavoriteDto favorite) throws Exception { 
		
		try {
			FavoriteDto result = service.createNew(favorite);
			return ResponseEntity.status(HttpStatus.CREATED).body(result);
		}catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
		
	}

}
