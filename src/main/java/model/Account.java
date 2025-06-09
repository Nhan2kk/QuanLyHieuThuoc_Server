package model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "accounts")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

public class Account implements Serializable {
    @Id
    @EqualsAndHashCode.Include
    @Column(name = "account_id", nullable = false, columnDefinition = "char(6)")
    private String accountID;

    private String password;

    @ToString.Exclude
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @ToString.Exclude
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "manager_id")
    private Manager manager;

    @Column(name = "is_logged_in")
    private boolean loggedIn = false;

}
