package com.example.test.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@NoArgsConstructor
@Setter
@Getter
@RequiredArgsConstructor
@AllArgsConstructor
@Entity(name = "product")
@Table(name = "product")
public class Product implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    Long id;

    @Column
    @NonNull
    private String name;

    @Column
    @Lob
    byte[] file;
}
