package by.library.mapper.list;

import by.library.dto.admin.UserDtoForAdmin;
import by.library.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface UserListMapper {

    UserListMapper INSTANCE = Mappers.getMapper(UserListMapper.class);

    List<User> toEntityList(List<UserDtoForAdmin> userDtoList);
    List<UserDtoForAdmin> toDtoList(List<User> userList);
}
