package com.troyka.market.domain.service;

import com.troyka.market.domain.DtoUser;
import com.troyka.market.domain.repository.DtoUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private DtoUserRepository dtoUserRepository;

    public List<DtoUser> getAll(){
        return dtoUserRepository.getAll();
    }
    public DtoUser getUserById(int id){
        return dtoUserRepository.getUserById(id);
    }
    public void update(DtoUser dtoUser){
        dtoUserRepository.update(dtoUser);
    }
    public DtoUser save(DtoUser dtoUser){
        return dtoUserRepository.save(dtoUser);
    }
    public void delete(int id){
        dtoUserRepository.delete(id);
    }
}
