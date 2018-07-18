package com.example.demo.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "security_roles")
public class SecurityRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String role;

    @ManyToMany(mappedBy = "roles", fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private List<SecurityAccount> accounts;


    public SecurityRole() {
    }

    public SecurityRole(String role) {
        this.role = role;
        this.accounts = accounts;
    }

    public SecurityRole(String role, List<SecurityAccount> accounts) {
        this.role = role;
        this.accounts = accounts;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public List<SecurityAccount> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<SecurityAccount> accounts) {
        this.accounts = accounts;
    }

    public void addSecurityAccount(SecurityAccount account){
        if (this.accounts == null)
            this.accounts = new ArrayList<>();
        accounts.add(account);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SecurityRole that = (SecurityRole) o;
        return Objects.equals(role, that.role);
    }

    @Override
    public int hashCode() {

        return Objects.hash(role);
    }


    public String toString(){
        return role;
    }
   /* @Override
    public String toString() {
        return "SecurityRole{" +
                "id=" + id +
                ", role='" + role + '\'' +
                '}';
    }*/
}
