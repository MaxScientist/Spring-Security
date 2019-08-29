package org.doit.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
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
@Table(name = "users")
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

    @OneToOne
    private Vehicle vehicle;
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


}
