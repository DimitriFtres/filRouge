package com.example.hello.Auth.Account;

import com.example.hello.security.entity.Credential;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int account_id;
    @NotNull
    private String firstname;
    @NotNull
    private String lastname;
    @OneToOne
    @JoinColumn(name="account_id")
    private Credential credential;


    public Account(AccountUpdatePayload account) {
        this.account_id = account.getAccount_id();
        this.firstname = account.getFirstname();
        this.lastname = account.getLastname();
        this.credential = account.getCredential();
    }

    public static class Builder
    {
        private int account_id;
        @NotNull
        private String firstname;
        @NotNull
        private String lastname;
        private Credential credential;

        public Builder setAccount_id(int account_id) {
            this.account_id = account_id;
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

        public Builder setCredential(Credential credential) {
            this.credential = credential;
            return this;
        }

        public Account build()
        {
            return new Account(account_id, firstname, lastname, credential);
        }
    }
}
