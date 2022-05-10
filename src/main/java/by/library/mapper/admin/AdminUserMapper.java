package by.library.mapper.admin;

import by.library.dto.admin.UserDtoForAdmin;
import by.library.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AdminUserMapper {

    AdminUserMapper INSTANCE = Mappers.getMapper(AdminUserMapper.class);

    User toEntity(UserDtoForAdmin userDto);
    UserDtoForAdmin toDto(User User);
}
