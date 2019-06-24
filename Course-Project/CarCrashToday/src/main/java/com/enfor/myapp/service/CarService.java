package com.enfor.myapp.service;

import com.enfor.myapp.entity.*;
import com.enfor.myapp.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarService {
    @Autowired
    private BrandOfCarRepository brandOfCarRepository;

    @Autowired
    private ModelOfCarRepository modelOfCarRepository;

    @Autowired
    private TypeOfBodyRepository typeOfBodyRepository;

    @Autowired
    private TypeOfTransportRepository typeOfTransportRepository;

    @Autowired
    private CarRepository carRepository;

    public Car buildCar(String regNum, Long brandOfCarId, Long modelOfCarId, Long typeOfBodyId, Long typeOfTransportId) {
        BrandOfCar brandOfCar = brandOfCarRepository.findById(brandOfCarId);
        ModelOfCar modelOfCar = modelOfCarRepository.findById(modelOfCarId);
        TypeOfBody typeOfBody = typeOfBodyRepository.findById(typeOfBodyId);
        TypeOfTransport typeOfTransport = typeOfTransportRepository.findById(typeOfTransportId);

        Car car = new Car(regNum, brandOfCar, modelOfCar, typeOfBody, typeOfTransport);
        if (car.getRegNum() != null) {
            carRepository.save(car);
            return car;
        }

        return null;
    }

}
