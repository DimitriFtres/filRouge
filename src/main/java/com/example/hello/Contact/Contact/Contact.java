package com.example.hello.Contact.Contact;

import com.example.hello.Org_Empl.Address.Address;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int contact_id;
    private String firstname;
    private String lastname;
    private String email;
    private String phone;

    @OneToMany(mappedBy = "contact")
    private List<Address> addresses;


    public Contact(ContactUpdatePayload contact) {
        this.contact_id = contact.getContact_id();
        this.firstname = contact.getFirstname();
        this.lastname = contact.getLastname();
        this.email = contact.getEmail();
        this.phone = contact.getPhone();
        this.addresses = contact.getAddresses();
    }

    public static class Builder
    {
        private int contact_id;
        private String firstname;
        private String lastname;
        private String email;
        private String phone;
        private List<Address> addresses;

        public Builder setContact_id(int contact_id) {
            this.contact_id = contact_id;
            return this;
        }

        public Builder setFirstname(String firstname) {
            this.firstname = firstname;
            return this;
        }

        public Builder setLastname(String lastname) {
            this.lastname = lastname;
            return this;
        }

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder setPhone(String phone) {
            this.phone = phone;
            return this;
        }

        public Builder setAddress(List<Address> addresses) {
            this.addresses = addresses;
            return this;
        }

        public Contact build()
        {
            return new Contact(contact_id, firstname, lastname, email, phone, addresses);
        }
    }

}
