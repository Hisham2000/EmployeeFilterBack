package com.example.employeefilter.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
@Builder
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
    @SequenceGenerator(name = "user_seq", initialValue = 1, sequenceName = "user_seq", allocationSize = 1)
    private Long id;

    private String name;

    @Column(unique = true)
    private String email;

    private String phone;
    private String code;
    @Column(name = "birth_date")
    private LocalDate birthDate;
    @Column(name="birth_city")
    private String birthCity;
    @Column(name = "job_title")
    private String jobTitle;
    private Boolean status;


    @JsonIgnore
    private String password;
    @ManyToOne()
    @JoinColumn(name = "role_id", referencedColumnName = "id")
    private Role role;

    @ManyToOne()
    @JoinColumn(name = "department_id", referencedColumnName = "id")
    private Department department;

    @ManyToOne()
    @JoinColumn(name = "contracts_types_id", referencedColumnName = "id")
    private ContractsTypes contractsTypes;

    @ManyToOne()
    @JoinColumn(name = "direct_manager_id", referencedColumnName = "id")
    private User directManager;



    @Override
    @JsonIgnore
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
        return grantedAuthorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    @JsonIgnore
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    @JsonIgnore
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    @JsonIgnore
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    @JsonIgnore
    public boolean isEnabled() {
        return true;
    }

    @Override
    public String toString() {
        String userData = "{" +
                "\"id\": " + id +
                ", \"name\": \"" + name + "\"" +
                ", \"email\": \"" + email + "\"" +
                ", \"role\" : \"" + role.getName() + "\"" +
                "}";
        return userData;
    }
}
