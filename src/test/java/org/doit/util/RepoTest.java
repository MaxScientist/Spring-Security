package org.doit.util;

import org.doit.config.CoreConfig;
import org.doit.config.PersistenceConfig;
import org.doit.config.SecurityConfig;
import org.doit.config.WebConfig;
import org.doit.dao.impl.HibernateUserDAO;
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
        address.setCity("4owtfwgep");
        address.setStreet("e2kwefw9rgopke");

        Address address1 = new Address();
        address1.setCity("o212fwfwgep");
        address1.setStreet("124eweffwgopke");

        User user = new User();
        user.setId(29L);
        user.setName("2opo");
        user.setSurname("ege1");
        user.setEmail("FJlk@g3m.com");
        user.setPassword("ropejgpo");
user.getListOfAddresses().add(address);
user.getListOfAddresses().add(address1);

//        user.setAddress(address);
        repository.save(user);
    }
}
