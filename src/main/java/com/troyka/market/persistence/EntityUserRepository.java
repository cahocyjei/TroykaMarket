package com.troyka.market.persistence;

import com.troyka.market.domain.DtoUser;
import com.troyka.market.domain.repository.DtoUserRepository;
import com.troyka.market.persistence.crud.UserCrudRepository;
import com.troyka.market.persistence.entitys.EntityUser;
import com.troyka.market.persistence.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class EntityUserRepository implements DtoUserRepository {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserCrudRepository userCrudRepository;

    @Override
    public List<DtoUser> getAll() {
        List<EntityUser> listUser = userCrudRepository.findAll();
        return userMapper.entityLisToDtoList(listUser);
    }

    @Override
    public void save(DtoUser dtoUser) {
        userCrudRepository.save(userMapper.dtoUserToEntityUser(dtoUser));
    }

    @Override
    public Optional<DtoUser> getUserById(int id) {
        Optional<EntityUser> entityUser = userCrudRepository.findById(id);
        return Optional.of(userMapper.entityUserToDtoUser(entityUser));
    }

    @Override
    public void update(DtoUser dtoUser) {

    }

    @Override
    public void delete(int id) {

    }
}
