package com.nubnefer.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.nubnefer.dto.UserDto;
import com.nubnefer.entities.Users;

@Mapper(componentModel = "Spring")
public interface UserMapper {

	@Mapping(target = "roleId",source ="role.id")
	@Mapping(target = "cartId",source ="cart.id")
	UserDto map (Users entity);
	
	//map from dao to entity
	@Mapping(source = "roleId",target ="role.id")
	Users unmap (UserDto dto);
	
	
	List<UserDto> mapList (List<Users> entities);

    List<Users> unmapList (List<UserDto> dtos);
}
