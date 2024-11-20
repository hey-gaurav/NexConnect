package com.NexConnect.entities;
import java.util.ArrayList;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import java.util.*;

@Entity
public class Contact {
    @Id
    private String id;
    private String name;
    private String email;
    private String phoneNumber;
    private String address;
    private String picture;
    @Column(length = 5000)
    private String description;
    private String websiteLink;
    private String linkedinLink;
    private boolean favourite=false;


    //mapping for many to one
    @ManyToOne
    private User user;

    @OneToMany(mappedBy = "contact",cascade = CascadeType.ALL,fetch = FetchType.EAGER,orphanRemoval = true)       //mapped by used to avoid bydirectional mapping
    private List<SocialLink> links=new ArrayList<>();
}
