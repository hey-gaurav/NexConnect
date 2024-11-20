package com.NexConnect.entities;

import javax.print.DocFlavor.STRING;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.*;

@Entity(name = "user")
@Table(name = "users")

//Getter setter are used directly as we are using Lambok
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class User {

    @Id     // to make user id primary key
    private String userId;
    @Column(name = "user_name",nullable = false)        //will set column name to user_name and nullable is used so name cant be null
    private String name;
    @Column(nullable = false,unique = true)
    private String email;
    private String password;
    @Column(length = 5000)
    private String about;
    @Column(length = 5000)
    private String profilePic;
    private String phoneNo;

    //information
    
    private boolean enabled=false;
    private boolean emailVerified=false;
    private boolean phoneVerified=false;

    //signup by which provider like google linkedin etc

    private Providers provider=Providers.SELF;
    private String providerID;

    //add more fields if needed

    
    //Mapping for one to may to contact table
    //cascade is used as if we delete user so all contacts of that user will be deleted
    //fetchtype lazy will make sure that when we need contacts of user then it only fetches data
    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL,fetch = FetchType.LAZY,orphanRemoval = true)       //mapped by used to avoid bydirectional mapping
    private List<Contact> contacts=new ArrayList<>();
}
