package org.doit.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Data
@NoArgsConstructor
@Entity
//@DiscriminatorValue("CAR")
public class FourWheeler extends Vehicle {

    private String SteeringWheeler;

}
