package fr.jeuxminicie.mappers;

import org.mapstruct.Mapper;

import fr.jeuxminicie.dtos.GameDto;
import fr.jeuxminicie.entities.Game;

@Mapper( componentModel="spring" )

public interface GameMapper {

	
	GameDto gameToGameDto(Game game);
	
	Game gameDtoToGame(GameDto gameDto);
}
