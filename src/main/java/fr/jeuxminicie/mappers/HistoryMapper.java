package fr.jeuxminicie.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import fr.jeuxminicie.dtos.HistoryDto;
import fr.jeuxminicie.entities.History;
import fr.jeuxminicie.repositories.MappingRepository;

@Mapper( componentModel="spring", uses = { MappingRepository.class })

public interface HistoryMapper {

	
	@Mapping(source="user.id", target="userId")
	@Mapping(source="game.id", target="gameId")	
	@Mapping(source="bestScore.id", target="bestScoreId")	
	HistoryDto historyToHistoryDto(History history);
	
	@Mapping(source="bestScoreId", target="bestScore")
	@Mapping(source="gameId", target="game")
	@Mapping(source="userId", target="user")	
	History historyDtoToHistory(HistoryDto historyDto);

}
