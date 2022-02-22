package com.troyka.market.domain.repository;

import com.troyka.market.domain.DtoUser;

import java.util.List;
import java.util.Optional;

public interface DtoUserRepository {
    List<DtoUser>getAll();
    void save(DtoUser dtoUser);
    Optional<DtoUser> getUserById(int id);
    void update(DtoUser dtoUser);
    void delete(int id);
}
