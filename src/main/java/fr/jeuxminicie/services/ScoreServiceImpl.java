package fr.jeuxminicie.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import fr.jeuxminicie.dtos.CountDto;
import fr.jeuxminicie.dtos.ScoreDto;
import fr.jeuxminicie.entities.Score;
import fr.jeuxminicie.exceptions.NotFoundException;
import fr.jeuxminicie.repositories.ScoreRepository;
import fr.jeuxminicie.tools.DtoTools;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class ScoreServiceImpl implements ScoreService{
	
	@Autowired
	private ScoreRepository repository;

	@Override
	public List<ScoreDto> getAll() throws Exception {

		List<Score> scores = repository.findAll();

		List<ScoreDto> result = new ArrayList<>();

		for (Score score : scores) {
			result.add(DtoTools.convert(score, ScoreDto.class));
		}

		return result;
	}

	@Override
	public List<ScoreDto> getAllByPage(int page, int max, String search) throws Exception {

		List<Score> scores = repository
				.findAllByUserLoginContainingOrUserEmailContainingOrGameNameContaining(search, search, search,
						PageRequest.of(page, max))
				.get().collect(Collectors.toList());

		List<ScoreDto> result = new ArrayList<>();

		for (Score score : scores) {
			result.add(DtoTools.convert(score, ScoreDto.class));
		}

		return result;

	}

	@Override
	public ScoreDto getById(long id) throws Exception {

		try {
			return DtoTools.convert(repository.getReferenceById(id), ScoreDto.class);
		} catch (Exception e) {
			throw new NotFoundException("The ressource with given id could not be found", e);
		}
	}

	@Override
	public CountDto count(String search) throws Exception {

		CountDto count = new CountDto();
		count.setNb(repository
				.findAllByUserLoginContainingOrUserEmailContainingOrGameNameContaining(search, search, search).size());
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
	public ScoreDto createNew(ScoreDto scoreDto) throws Exception {

		Score scoreToPersist = DtoTools.convert(scoreDto, Score.class);

		Score scorePersisted = repository.saveAndFlush(scoreToPersist);

		return DtoTools.convert(scorePersisted, ScoreDto.class);
	}
	
	

}
