package com.example.hello.Auth.Credential;

import com.example.hello.Auth.Account.Account;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Credential {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int credential_id;
    @NotNull
    private String username;
    @NotNull
    private String password;
    @NotNull
    private String email;
    private boolean actif;
    @OneToOne
    @JoinColumn(name = "account_id", nullable = false, referencedColumnName = "account_id")
    @JsonIgnore
    private Account account;


    public Credential(CredentialUpdatePayload credential)
    {
        this.credential_id = credential.getCredential_id();
        this.username = credential.getUsername();
        this.password = credential.getPassword();
        this.email = credential.getEmail();
        this.actif = credential.isActif();
        this.account = credential.getAccount();
    }
    public static class Builder
    {
        private int credential_id;
        @NotNull
        private String username;
        @NotNull
        private String password;
        @NotNull
        private String email;
        private boolean actif;
        private Account account;

        public Builder setCredential_id(int credential_id) {
            this.credential_id = credential_id;
            return this;
        }

        public Builder setUsername(String username) {
            this.username = username;
            return this;
        }

        public Builder setPassword(String password) {
            this.password = password;
            return this;
        }

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder setActif(boolean actif) {
            this.actif = actif;
            return this;
        }

        public Builder setAccount(Account account) {
            this.account = account;
            return this;
        }

        public Credential build()
        {
            return new Credential(credential_id, username, password, email, actif, account);
        }
    }

}
