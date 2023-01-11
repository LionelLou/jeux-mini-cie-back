package fr.jeuxminicie.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;

import fr.jeuxminicie.dtos.CountDto;
import fr.jeuxminicie.dtos.HistoryDto;
import fr.jeuxminicie.entities.History;
import fr.jeuxminicie.exceptions.NotFoundException;
import fr.jeuxminicie.repositories.HistoryRepository;
import fr.jeuxminicie.tools.DtoTools;

public class HistoryServiceImpl implements HistoryService{

	@Autowired
	private HistoryRepository repository;

	@Override
	public List<HistoryDto> getAll() throws Exception {

		List<History> historys = repository.findAll();

		List<HistoryDto> result = new ArrayList<>();

		for (History history : historys) {
			result.add(DtoTools.convert(history, HistoryDto.class));
		}

		return result;
	}

	@Override
	public List<HistoryDto> getAllByPage(int page, int max, String search) throws Exception {

		List<History> historys = repository
				.findAllByUserLoginContainingOrUserEmailContainingOrGameNameContaining(search, search, search,
						PageRequest.of(page, max))
				.get().collect(Collectors.toList());

		List<HistoryDto> result = new ArrayList<>();

		for (History history : historys) {
			result.add(DtoTools.convert(history, HistoryDto.class));
		}

		return result;

	}

	@Override
	public HistoryDto getById(long id) throws Exception {

		try {
			return DtoTools.convert(repository.getReferenceById(id), HistoryDto.class);
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
	public HistoryDto createNew(HistoryDto HistoryDto) throws Exception {

		History historyToPersist = DtoTools.convert(HistoryDto, History.class);

		History historyPersisted = repository.saveAndFlush(historyToPersist);

		return DtoTools.convert(historyPersisted, HistoryDto.class);
	}



	@Override
	public List<HistoryDto> getAllByUserId(long userId) throws Exception {
		
		List<History> historys = repository.findAllByUserId(userId);

		List<HistoryDto> result = new ArrayList<>();

		for (History history : historys) {
			result.add(DtoTools.convert(history, HistoryDto.class));
		}

		return result;
	}

}
