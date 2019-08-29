package org.doit.util;

import org.doit.config.CoreConfig;
import org.doit.config.PersistenceConfig;
import org.doit.config.SecurityConfig;
import org.doit.config.WebConfig;
import org.doit.dao.impl.HibernateUserDAO;
import org.doit.model.Address;
import org.doit.model.User;
import org.doit.model.Vehicle;
import org.doit.repository.UserRepository;
import org.doit.repository.VehicleRepository;
import org.doit.service.UserService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
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

    @Autowired
    private VehicleRepository vehicleRepository;

//
//    @Autowired
//    private SessionFactory factory;

    @Test
    public void testForRepo(){
//
//
        User user = new User();

        user.setName("AAAAA");
        user.setSurname("BBBB");
        user.setEmail("1Esd521.com");
        user.setPassword("ropejgpo");

        Vehicle vehicle = new Vehicle();
        vehicle.setVehicleName("Volva");

        Vehicle vehicle1 = new Vehicle();
        vehicle1.setVehicleName("Nissan");
//
        user.getVehicles().add(vehicle);
        user.getVehicles().add(vehicle1);
        vehicle.setUser(user);
        vehicle1.setUser(user);
//        user.setVehicle(vehicle);
//user.getListOfAddresses().add(address);
//user.getListOfAddresses().add(address1);
        repository.save(user);
        vehicleRepository.save(vehicle);
        vehicleRepository.save(vehicle1);


//        Session session = factory.openSession();
//        session.save(user);
//        session.save(vehicle);
//        session.save(vehicle1);
//
//        session.beginTransaction();

//          session.getTransaction().commit();
//        session.close();
//        repository.deleteAll();



//        session.getTransaction().commit(); /// don't use this option, 'cause The programm will throw exception
//        session.getTransaction().commit();
//session.close();
//        user.setAddress(address);
//        repository.save(vehicle);
//        repository.save(user);
    }
}
