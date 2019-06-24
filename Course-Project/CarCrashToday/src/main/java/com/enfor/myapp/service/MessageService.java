package com.enfor.myapp.service;

import com.enfor.myapp.entity.Car;
import com.enfor.myapp.entity.Message;
import com.enfor.myapp.repository.MessageRepository;
import com.enfor.myapp.repository.StatusesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class MessageService {
    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private CarService carService;

    public Page<Message> messageList(Pageable pageable, String filter) {
        if (filter != null && !filter.isEmpty()) {
            return messageRepository.findByTag(filter, pageable);
        } else {
            return messageRepository.findAll(pageable);
        }

    }

    public Message buildMesaage(String regNum1, Long brandOfCar1, Long modelOfCar1, Long typeOfBody1,
                                Long typeOfTransport1, String regNum2, Long brandOfCar2, Long modelOfCar2,
                                Long typeOfBody2, Long typeOfTransport2, Message message) {

        if (!StringUtils.isEmpty(regNum1)) {

            Car car = carService.buildCar(regNum1, brandOfCar1, modelOfCar1, typeOfBody1, typeOfTransport1);
            if (car != null) {
                message.setCar1(car);
            }

            if (!StringUtils.isEmpty(regNum2)) {
                car = carService.buildCar(regNum2, brandOfCar2, modelOfCar2, typeOfBody2, typeOfTransport2);
                if (car != null) {
                    message.setCar2(car);
                } else {
                    message.setCar2(null);
                }
            }
        }
        return message;
    }
}
