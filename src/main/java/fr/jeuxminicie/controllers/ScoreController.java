package fr.jeuxminicie.controllers;

import java.util.List;
import java.util.Optional;

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

import fr.jeuxminicie.dtos.CountDto;
import fr.jeuxminicie.dtos.ScoreDto;
import fr.jeuxminicie.exceptions.NotFoundException;
import fr.jeuxminicie.services.ScoreService;

@RestController
@RequestMapping("api/scores")
public class ScoreController {

	@Autowired
	private ScoreService service;


	@GetMapping(produces = "application/json")
	public ResponseEntity<Object> getAll() throws Exception {
		
		try {
			List<ScoreDto> result = service.getAll();
			return ResponseEntity.status(HttpStatus.OK).body(result);
		}catch (Exception e){
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("An error occured, please check you request or contact administrator"); 
					
		}
			
	}

	@GetMapping(value = "/{id}", produces = "application/json")
	public ResponseEntity<Object> getById(@PathVariable("id") long id) throws Exception {

		try {
			ScoreDto result = service.getById(id);
			return ResponseEntity.status(HttpStatus.OK).body(result);

		} catch (NotFoundException e) {

			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}

	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<String> deleteById(@PathVariable("id") long id) throws Exception {

		try {
			service.deleteById(id);
			return ResponseEntity.status(HttpStatus.OK).body("Successfully deleted score with id : " + id);

		} catch (NotFoundException e) {

			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}

	}

	@PostMapping(value = "/create", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Object> createNewScore(@RequestBody ScoreDto score) throws Exception {

		try {
			ScoreDto result = service.createNew(score);
			return ResponseEntity.status(HttpStatus.CREATED).body(result);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}

	}

	@GetMapping(value = { "/count", "/count/{search}" }, produces = "application/json")
	public ResponseEntity<Object> countBySearchWord(
			@PathVariable(value = "search", required = false) Optional<String> search) throws Exception {

		try {
			CountDto result = null;

			if (search.isPresent()) {
				result = service.count(search.get());
			} else {
				result = service.count("");
			}

			return ResponseEntity.status(HttpStatus.OK).body(result);

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("An error occured while trying to fetch data");
		}

	}


	@GetMapping(value = { "/pageable/{page}/{size}",
			"/pageable/{page}/{size}/{search}" }, produces = "application/json")
	public ResponseEntity<Object> getAllByPage(@PathVariable("page") int page, @PathVariable("size") int size,
			@PathVariable(value = "search", required = false) Optional<String> search) throws Exception {

		try {
			List<ScoreDto> result = null;

			if (search.isPresent()) {
				result = service.getAllByPage(page - 1, size, search.get());
			} else {
				result = service.getAllByPage(page - 1, size, "");
			}

			return ResponseEntity.status(HttpStatus.OK).body(result);

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body("An error occured while trying to fetch data, check your request");
		}

	}
}
