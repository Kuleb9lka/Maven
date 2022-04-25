package by.library.mapper.admin;

import by.library.dto.admin.AdminTicketDto;
import by.library.model.Ticket;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AdminTicketMapper {

    AdminTicketMapper INSTANCE = Mappers.getMapper(AdminTicketMapper.class);

    Ticket toEntity(AdminTicketDto ticketDto);
    AdminTicketDto toDto(Ticket ticket);
}
