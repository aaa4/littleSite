package com.example.demo.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "security_accounts")
public class SecurityAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String username;
    private String password;
    private boolean enabled;
    @Transient
    private String stringOfRoles;

    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinTable(
            name = "security_accounts_roles",
            joinColumns = {@JoinColumn(name = "sar_account_id")},
            inverseJoinColumns = {@JoinColumn(name="sar_role_id")}
    )
    private Set<SecurityRole> roles;

    public SecurityAccount() {
    }

    public SecurityAccount(String username) {
        this.username = username;
    }

    public SecurityAccount(String username, String password, boolean enabled, Set<SecurityRole> roles) {
        this.username = username;
        this.password = password;
        this.enabled = enabled;
        this.roles = roles;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Set<SecurityRole> getRoles() {
        return roles;
    }

    public void setRoles(Set<SecurityRole> roles) {
        this.roles = roles;
    }

    public String getStringOfRoles() {
        return stringOfRoles;
    }

    public void setStringOfRoles(String stringOfRoles) {
        this.stringOfRoles = stringOfRoles;
    }

    //добавляй роли через сервис. там отдельный метод
    public void addRole(SecurityRole role){

        if (this.roles == null)
            setRoles(new HashSet<>());
        this.roles.add(role);
        role.addSecurityAccount(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SecurityAccount that = (SecurityAccount) o;
        return Objects.equals(username, that.username);
    }

    @Override
    public int hashCode() {

        return Objects.hash(username);
    }

    @Override
    public String toString() {
        return "SecurityAccount{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", enabled=" + enabled +
                ", roles=" + roles +
                '}';
    }



    public SecurityAccount createEmptyInstance(){
        return  new SecurityAccount("","",true, new HashSet<>());
    }
}
