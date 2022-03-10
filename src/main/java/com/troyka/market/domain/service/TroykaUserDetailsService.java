package com.troyka.market.domain.service;

import com.troyka.market.domain.dto.MyUserDetails;
import com.troyka.market.persistence.EntityUserRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class TroykaUserDetailsService implements UserDetailsService {

    private  Log LOGGER = LogFactory.getLog(TroykaUserDetailsService.class );

    @Autowired
    private  EntityUserRepository entityUserRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        LOGGER.info("Hemos ingresado al metodo loadUserByUsername: " + username);
           LOGGER.debug("Valores: " + user.getUsername());
        return  new MyUserDetails(username);
    }
}
