package by.library.mapper.admin;

import by.library.dto.admin.AdminUserDto;
import by.library.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AdminUserMapper {

    AdminUserMapper INSTANCE = Mappers.getMapper(AdminUserMapper.class);

    User toEntity(AdminUserDto userDto);
    AdminUserDto toDto(User User);
}
