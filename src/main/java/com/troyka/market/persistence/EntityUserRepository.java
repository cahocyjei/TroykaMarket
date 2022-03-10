package com.troyka.market.persistence;

import com.troyka.market.domain.dto.DtoUser;
import com.troyka.market.domain.repository.DtoUserRepository;
import com.troyka.market.persistence.crud.UserCrudRepository;
import com.troyka.market.persistence.entitys.EntityUser;
import com.troyka.market.persistence.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
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
        return userMapper.listEntityUserToListDtoUser(listUser);
    }

    @Override
    public DtoUser save(DtoUser dtoUser) {
        EntityUser toSave = userMapper.dtoUserToEntityUser(dtoUser);
        return userMapper.entityUserToDtoUser(userCrudRepository.save(toSave));
    }

    @Override
    public Optional<DtoUser> getUser(int id) {
        return userCrudRepository.findById(id).map(user -> userMapper.entityUserToDtoUser(user));
    }

    @Override
    public void update(DtoUser dtoUser) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public User findByUserName(String username) {
        return userCrudRepository.findByFullName(username);
    }


}
