package org.doit.util;

import org.doit.config.CoreConfig;
import org.doit.config.PersistenceConfig;
import org.doit.config.SecurityConfig;
import org.doit.config.WebConfig;
import org.doit.model.Address;
import org.doit.model.User;
import org.doit.repository.UserRepository;
import org.doit.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {
        WebConfig.class, PersistenceConfig.class,
        CoreConfig.class, SecurityConfig.class
})
@WebAppConfiguration
public class RepoTest {

    @Autowired
    private UserService repository;

    @Test
    public void testForRepo(){
        Address address = new Address();
        address.setCity("oekkgep");
        address.setStreet("ekgopke");
        User user = new User();
        user.setId(20L);
        user.setName("ogerpo");
        user.setSurname("egjepgje");
        user.setEmail("10xb-kf-2@gm.com");
        user.setPassword("rogpejgpo");
//        user.setAddress(address);
        repository.add(user,address);
    }
}
