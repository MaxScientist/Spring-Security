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
    private UserRepository repository;

    @Test
    public void testForRepo(){
        Address address = new Address();
        address.setCity("oekkewtfwgep");
        address.setStreet("ekwefwrgopke");

        Address address1 = new Address();
        address1.setCity("oekkegvwefwfwgep");
        address1.setStreet("ekw2eweffwgopke");

        User user = new User();
        user.setId(25L);
        user.setName("ogwrpo");
        user.setSurname("egwfeejepgje");
        user.setEmail("rwweefkf-2@g3m.com");
        user.setPassword("rogwefpejgpo");
user.getListOfAddresses().add(address);
user.getListOfAddresses().add(address1);

//        user.setAddress(address);
        repository.save(user);
    }
}
