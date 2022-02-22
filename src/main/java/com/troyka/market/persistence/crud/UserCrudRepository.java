package com.troyka.market.persistence.crud;

import com.troyka.market.persistence.entitys.EntityUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserCrudRepository extends JpaRepository<EntityUser,Integer>{
}
