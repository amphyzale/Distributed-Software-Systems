package com.enfor.myapp.entity;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Set;

@Entity
@Table(name = "brand_of_cars")
public class BrandOfCar {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "Пожалйста, заполните поле!")
    @Length(max = 256,  message = "Многа букав!")
    private String name;

    @OneToMany(mappedBy = "brandOfCar", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<ModelOfCar> modelOfCars;

    @OneToMany(mappedBy = "car_brandOfCar", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Car> cars;
}
