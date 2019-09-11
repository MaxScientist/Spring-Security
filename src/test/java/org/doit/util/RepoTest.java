package org.doit.util;

import org.doit.config.CoreConfig;
import org.doit.config.PersistenceConfig;
import org.doit.config.SecurityConfig;
import org.doit.config.WebConfig;
import org.doit.dao.impl.HibernateUserDAO;
import org.doit.model.*;
import org.doit.repository.UserRepository;
import org.doit.repository.VehicleRepository;
import org.doit.service.UserService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
//import org.hibernate.Criteria
import java.util.List;


@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {
        WebConfig.class, PersistenceConfig.class,
        CoreConfig.class, SecurityConfig.class
})
@WebAppConfiguration
public class RepoTest {
////
    @Autowired
    private UserRepository repository;

    @Autowired
    private VehicleRepository vehicleRepository;

//
    @Autowired
    private SessionFactory factory;

    @Test
    public void testForRepo(){
//
//
//        User user = new User();
//
//        user.setName("AAAAA");
//        user.setSurname("BBBB");
//        user.setEmail("zf2gdfo1.com");
//        user.setPassword("ropejgpo");
//
//        Vehicle vehicle = new Vehicle();
//        vehicle.setVehicleName("Skoda");
//
//        Vehicle vehicle1 = new Vehicle();
//        vehicle1.setVehicleName("Honda");
////
//        user.getVehicles().add(vehicle);
//        user.getVehicles().add(vehicle1);
//
//        repository.save(user);
//
//        Session session = factory.openSession();
//        session.persist(user);
//        session.save(vehicle);
//        session.save(vehicle1);
//        user.setVehicle(vehicle);
//user.getListOfAddresses().add(address);
//user.getListOfAddresses().add(address1);
//
//
//        repository.save(user);
//        vehicleRepository.save(vehicle);
//        vehicleRepository.save(vehicle1);
//
//        vehicleRepository.deleteAll();
//        repository.deleteAll();
//        Session session = factory.openSession();
//        session.save(user);
//        session.save(vehicle);
//        session.save(vehicle1);
//
//        session.beginTransaction();
//
//          session.getTransaction().commit();
//        session.close();
//        repository.deleteAll();
//
//
//
//        session.getTransaction().commit(); /// don't use this option, 'cause The programm will throw exception
//        session.getTransaction().commit();
//session.close();
//        user.setAddress(address);
//        repository.save(vehicle);
//        repository.save(user);
//        Vehicle vehicle = new Vehicle();
//        vehicle.setVehicleName("Car");
////
//        TwoWheeler bike = new TwoWheeler();
//         bike.setVehicleName("Dugatti");
//         bike.setSteeringHandle("Bike steering handle");
//
//        FourWheeler car = new FourWheeler();
//            car.setVehicleName("Volkswaggen");
//            car.setSteeringWheeler("Car steering wheeler");
//
//        vehicleRepository.save(vehicle);
//        vehicleRepository.save(bike);
//        vehicleRepository.save(car);
        Session session = factory.openSession();
        session.beginTransaction();
//        User user= (User) session.get(User.class,4L);
//        user.setName("ShaimardanKozhakhmetov");
//        session.update(user);
        Query query = session.createQuery("from User");
        List users = query.list();

        session.getTransaction().commit();
        session.close();

//        System.out.println("The number of users is " + repository.findAll());
    }
}
