package org.doit.model;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@NoArgsConstructor
@Embeddable
public class Address implements Serializable {

    private String street;

    private String city;
}
