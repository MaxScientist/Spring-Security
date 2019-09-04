package org.doit.model;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Data
@NoArgsConstructor
@Entity
//@DiscriminatorValue("BIKE")
public class TwoWheeler extends Vehicle {

    private String SteeringHandle;

}
