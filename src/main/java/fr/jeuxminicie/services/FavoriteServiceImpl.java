package fr.jeuxminicie.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import fr.jeuxminicie.dtos.CountDto;
import fr.jeuxminicie.dtos.FavoriteDto;
import fr.jeuxminicie.entities.Favorite;
import fr.jeuxminicie.exceptions.NotFoundException;
import fr.jeuxminicie.repositories.FavoriteRepository;
import fr.jeuxminicie.tools.DtoTools;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class FavoriteServiceImpl implements FavoriteService {

	@Autowired
	private FavoriteRepository repository;

	@Override
	public List<FavoriteDto> getAll() throws Exception {

		List<Favorite> favorites = repository.findAll();

		List<FavoriteDto> result = new ArrayList<>();

		for (Favorite favorite : favorites) {
			result.add(DtoTools.convert(favorite, FavoriteDto.class));
		}

		return result;
	}

	@Override
	public List<FavoriteDto> getAllByPage(int page, int max, String search) throws Exception {

		List<Favorite> favorites = repository
				.findAllByUserLoginContainingOrUserEmailContainingOrGameNameContaining(search, search, search,
						PageRequest.of(page, max))
				.get().collect(Collectors.toList());

		List<FavoriteDto> result = new ArrayList<>();

		for (Favorite favorite : favorites) {
			result.add(DtoTools.convert(favorite, FavoriteDto.class));
		}

		return result;

	}

	@Override
	public FavoriteDto getById(long id) throws Exception {

		try {
			return DtoTools.convert(repository.getReferenceById(id), FavoriteDto.class);
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
	public FavoriteDto createNew(FavoriteDto favoriteDto) throws Exception {

		Favorite favoriteToPersist = DtoTools.convert(favoriteDto, Favorite.class);

		Favorite favoritePersisted = repository.saveAndFlush(favoriteToPersist);

		return DtoTools.convert(favoritePersisted, FavoriteDto.class);
	}

	@Override
	public List<FavoriteDto> getAllFavoritesForUserIdByPage(int page, int max, long userId, String gameName)
			throws Exception {

		List<Favorite> favorites = repository
				.findAllByUserIdAndGameNameContaining(userId, gameName, PageRequest.of(page, max)).get()
				.collect(Collectors.toList());

		List<FavoriteDto> result = new ArrayList<>();

		for (Favorite favorite : favorites) {
			result.add(DtoTools.convert(favorite, FavoriteDto.class));
		}

		return result;

	}

	@Override
	public CountDto countForUserId(long userId, String search) throws Exception {

		CountDto count = new CountDto();
		count.setNb(repository.findAllByUserIdAndGameNameContaining(userId, search).size());
		return count;

	}

}
