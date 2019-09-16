package org.doit.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.management.ConstructorParameters;
import javax.persistence.*;
import java.beans.ConstructorProperties;
import java.util.ArrayList;
import java.util.Collection;
//
//@Data
//@NoArgsConstructor
//@Entity
//@Inheritance(strategy = InheritanceType.JOINED)        //Earlier we used SINGLE_TABLE and PER_CLASS_TABLE options to
//                                                    //to Implement our inheritance
//@DiscriminatorColumn(
//        name = "VEHICLE_TYPE",
//        discriminatorType = DiscriminatorType.STRING
//)
public class Vehicle {
    @Id
    @GeneratedValue
    private int vehicleId;

    private String vehicleName;
//
//    @ManyToOne
//    private User user;

//    @ManyToOne
//    private User user;
}
