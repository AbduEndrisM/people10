package com.people10.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
public class Customer implements Serializable {

    @Id
    private Long id;
    @NotNull
    private LocalDateTime createdAt;
    private String ip;
    private double longitude;
    private double latitude;
    private String firstName;
    private String lastName;

    @Email
    @NotNull
    @Column(unique = true)
    private String email;
    private LocalDateTime updatedAt;

}
