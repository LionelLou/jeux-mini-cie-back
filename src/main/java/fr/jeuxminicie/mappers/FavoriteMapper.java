package fr.jeuxminicie.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import fr.jeuxminicie.dtos.FavoriteDto;
import fr.jeuxminicie.entities.Favorite;

@Mapper(componentModel = "spring")
public interface FavoriteMapper {

	@Mapping(source="user.id", target="userId")
	@Mapping(source="game.id", target="gameId")
	FavoriteDto favoriteToFavoriteDto(Favorite favorite);
	
//	@Mapping(source="userId", target="user")
//	@Mapping(source="gameId", target="game")
//	Favorite favoriteDtoToFavorite(FavoriteDto FavoriteDto);
	
}
