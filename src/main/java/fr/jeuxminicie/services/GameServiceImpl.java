package fr.jeuxminicie.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import fr.jeuxminicie.dtos.CountDto;
import fr.jeuxminicie.dtos.GameDto;
import fr.jeuxminicie.entities.Game;
import fr.jeuxminicie.exceptions.NotFoundException;
import fr.jeuxminicie.repositories.GameRepository;
import fr.jeuxminicie.tools.DtoTools;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class GameServiceImpl implements GameService{
	
	
	@Autowired
	private GameRepository repository;
	

	@Override
	public List<GameDto> getAll() throws Exception {

		List<Game> games = repository.findAll();

		List<GameDto> result = new ArrayList<>();

		for (Game game : games) {
			result.add(DtoTools.convert(game, GameDto.class));
		}

		return result;
	}

	@Override
	public List<GameDto> getAllByPage(int page, int max, String search) throws Exception {

		List<Game> games = repository.findAllByNameContaining(search, PageRequest.of(page, max)).get().collect(Collectors.toList());

		List<GameDto> result = new ArrayList<>();

		for (Game game : games) {
			result.add(DtoTools.convert(game, GameDto.class));
		}

		return result;

	}

	@Override
	public GameDto getById(long id) throws Exception {

		try {
			return DtoTools.convert(repository.getReferenceById(id), GameDto.class);
		} catch (Exception e) {
			throw new NotFoundException("The ressource with given id could not be found", e);
		}
	}

	@Override
	public CountDto count(String search) throws Exception {

		CountDto count = new CountDto();
		count.setNb(repository.findAllByNameContaining(search).size());
		return count;

	}

	@Override
	public void deleteById(long id) throws Exception {

		try {
			repository.deleteById(id);
		} catch (Exception e) {
			throw new NotFoundException("The ressource with given id could not be found", e);
		}
	}

	@Override
	public GameDto createNew(GameDto gameDto) throws Exception {
		
		Game gameToPersist = DtoTools.convert(gameDto, Game.class);

		Game gamePersisted = repository.saveAndFlush(gameToPersist);

		return DtoTools.convert(gamePersisted, GameDto.class);
	}
	
}
