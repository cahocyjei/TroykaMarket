package com.troyka.market.domain.repository;

import com.troyka.market.domain.dto.DtoUser;

import java.util.List;
import java.util.Optional;

public interface DtoUserRepository {
    List<DtoUser>getAll();
    DtoUser save(DtoUser dtoUser);
    Optional<DtoUser> getUser(int id);
    void update(DtoUser dtoUser);
    void delete(int id);
}
