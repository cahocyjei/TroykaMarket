package com.troyka.market.persistence.crud;

import com.troyka.market.domain.dto.DtoUser;
import com.troyka.market.persistence.entitys.EntityUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.User;

public interface UserCrudRepository extends JpaRepository<EntityUser,Integer> {

    User findByFullName(String username);
}
