package com.example.hello.Contact.Contact;

import com.example.hello.Org_Empl.Address.Address;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int contact_id;
    private String firstname;
    private String lastname;
    private String email;
    private String phone;

    @OneToMany(targetEntity = Address.class)
    private List<Address> addresses = new ArrayList<>();

}
