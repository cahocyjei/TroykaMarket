package com.troyka.market.persistence.mapper;

import com.troyka.market.domain.DtoUser;
import com.troyka.market.persistence.entitys.EntityUser;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;
import java.util.Optional;

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

    })
    EntityUser dtoUserToEntityUser(DtoUser dtoUser);
    List<EntityUser> dtoLisToEntityList(List<DtoUser> dtoUsers);

    @InheritInverseConfiguration
    DtoUser entityUserToDtoUser(Optional<EntityUser> entityUser);
    List<DtoUser> entityLisToDtoList(List<EntityUser> entityUsers);
}
