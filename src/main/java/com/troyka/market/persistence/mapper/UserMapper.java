package com.troyka.market.persistence.mapper;


import com.troyka.market.domain.dto.DtoUser;
import com.troyka.market.persistence.entitys.EntityUser;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mappings({
            @Mapping(source = "id",target = "id"),
            @Mapping(source = "fullName",target = "fullName"),
            @Mapping(source = "lastName",target = "lastName"),
            @Mapping(source = "email",target = "email"),
            @Mapping(source = "password",target = "password"),
            @Mapping(source = "address",target = "address"),
            @Mapping(source = "country",target = "country"),
            @Mapping(source = "city",target = "city"),
            @Mapping(source = "date",target = "date"),
            @Mapping(source = "rol",target = "rol"),
    })
    EntityUser dtoUserToEntityUser(DtoUser dtoUser);
    List<EntityUser> listDtoUserToListEntityUser(List<DtoUser> dtoUserList);

    @InheritInverseConfiguration
    DtoUser entityUserToDtoUser(EntityUser entityUser);
    List<DtoUser> listEntityUserToListDtoUser(List<EntityUser> entityUserList);
}
