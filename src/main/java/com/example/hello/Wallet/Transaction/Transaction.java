package com.example.hello.Wallet.Transaction;

import com.example.hello.Org_Empl.Organization.Organization;
import com.example.hello.Wallet.Document.Document;
import com.example.hello.Wallet.Wallet.Wallet;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int transaction_id;
    private String type;
    private Float amount;

    @ManyToOne
    @JoinColumn(name = "FK_wallet_id", nullable = false, referencedColumnName = "wallet_id")
    private Wallet wallet;


    public static class Builder
    {
        private int transaction_id;
        private String type;
        private Float amount;
        private Wallet wallet;

        public Builder setWallet(Wallet wallet) {
            this.wallet = wallet;
            return this;
        }

        public Builder setTransaction_id(int transaction_id) {
            this.transaction_id = transaction_id;
            return this;
        }

        public Builder setType(String type) {
            this.type = type;
            return this;
        }

        public Builder setAmount(Float amount) {
            this.amount = amount;
            return this;
        }

        public Transaction build()
        {
            return new Transaction(transaction_id, type, amount, wallet);
        }

    }
}
