package org.doit.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.management.ConstructorParameters;
import javax.persistence.*;
import java.beans.ConstructorProperties;

@Data
@NoArgsConstructor
@Entity
public class Vehicle {
    @Id
    @GeneratedValue
    private int vehicleId;

    private String vehicleName;

    @ManyToOne
    private User user;
}
