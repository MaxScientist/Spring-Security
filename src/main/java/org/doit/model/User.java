package org.doit.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
@Access(AccessType.FIELD)
@Table(name = "USERS")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name is required")
    private String name;

    @Size(min = 1, max = 10, message = "Surname should be from 1 to 10 symbols")
    private String surname;

    @Email
    private String email;

    @Size(min = 7, message = "Minimum 7 symbols")
    private String password;

    private boolean enabled = true;
//
//    @OneToMany(cascade = CascadeType.ALL)                                           //This is linking of OneToMany relation
//    @JoinTable(name = "VEHICLE_USER",
//    joinColumns = @JoinColumn(name = "USER_ID"),
//    inverseJoinColumns = @JoinColumn(name = "VEHICLE_ID"))
//    @OneToMany(cascade = CascadeType.ALL)
//    private Collection<Vehicle> vehicles = new ArrayList<>();
//
//    @OneToMany
//    @JoinTable(
//    joinColumns = {@JoinColumn(name="USERS_ID")},
//    inverseJoinColumns = @JoinColumn(name = "VEHICLE_ID"))

//    @JoinTable(name = "USER_VEHICLE",
//            joinColumns = @JoinColumn(name = "USER_ID"),
//            inverseJoinColumns = @JoinColumn(name = "VEHICLE_ID"))
//    private Collection<Vehicle> vehicle = new ArrayList<Vehicle>();
    //Embedding the class into entity table
    //Collection Mapping and adding key, and fetching field
    //Fetching - is proxy object, which allows us getting neither
    // deleting file inf or if session is closed() to get the
    // inf from close() session
//    @Embedded
//    private Address address;
//
//    @ElementCollection(fetch=FetchType.EAGER)
//    @JoinTable(name = "User_Address",
//    joinColumns = @JoinColumn(name = "USER_ID")
//    )
////    @GenericGenerator(name = "sequence",strategy = "sequence")
//////    @GeneratedValue(ngenerator = "sequence-gen",strategy = GenerationType.SEQUENCE)
////    @CollectionId(columns = {
////            @Column(name = "ADDRESS_ID")
////    }, generator = "sequence", type = @Type(type = "long"))
//    private Collection<Address> listOfAddresses = new ArrayList<Address>();

        @Enumerated(EnumType.STRING)
        @CollectionTable(name = "user_roles", joinColumns=@JoinColumn
                (name = "user_id"))
        @Column(name = "role")
        @ElementCollection(fetch = FetchType.EAGER)
        @Fetch(FetchMode.SUBSELECT)
        private Set<Role> roles;

        public boolean isEnabled(){
            return enabled;
        }


}
