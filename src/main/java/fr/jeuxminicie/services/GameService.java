package fr.jeuxminicie.services;

import fr.jeuxminicie.dtos.GameDto;

public interface GameService extends GenericService<GameDto>{
	
	
	GameDto createNew(GameDto gameDto) throws Exception;

}
