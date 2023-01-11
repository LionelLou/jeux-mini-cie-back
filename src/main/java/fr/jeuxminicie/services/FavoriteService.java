package fr.jeuxminicie.services;

import java.util.List;

import fr.jeuxminicie.dtos.CountDto;
import fr.jeuxminicie.dtos.FavoriteDto;

public interface FavoriteService extends GenericService<FavoriteDto>{
	
	
	FavoriteDto createNew(FavoriteDto favoriteDto) throws Exception;

	List<FavoriteDto> getAllFavoritesForUserIdByPage(int page, int max, long userId, String gameName) throws Exception;
	
	CountDto countForUserId(long userId, String search) throws Exception;
}
