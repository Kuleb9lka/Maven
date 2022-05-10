package by.library.mapper.list;

import by.library.dto.admin.TicketDtoForAdmin;
import by.library.model.Ticket;
import org.mapstruct.factory.Mappers;

import java.util.List;

public interface TicketListMapper {

    TicketListMapper INSTANCE = Mappers.getMapper(TicketListMapper.class);

    List<Ticket> toEntityList(List<TicketDtoForAdmin> ticketDtoList);
    List<TicketDtoForAdmin> toDtoList(List<Ticket> ticketList);
}