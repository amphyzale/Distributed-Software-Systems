package com.enfor.myapp.entity;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Set;

@Entity
@Table(name = "model_of_cars")
public class ModelOfCar {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "Пожалйста, заполните поле!")
    @Length(max = 256,  message = "Многа букав!")
    private String name;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "brand_id")
    private BrandOfCar brandOfCar;

    @OneToMany(mappedBy = "car_modelOfCar", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Car> cars;
}
