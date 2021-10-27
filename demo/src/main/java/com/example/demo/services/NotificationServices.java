package com.example.demo.services;

import com.example.demo.entities.Employee;
import com.example.demo.entities.Employment;
import com.example.demo.entities.Notification;
import com.example.demo.repositories.EmployeeRepository;
import com.example.demo.repositories.NotificationRepository;
import org.apache.catalina.LifecycleState;
import org.aspectj.weaver.ast.Not;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class NotificationServices {
    @Autowired
    private NotificationRepository notificationRepository;

    public void createNotifications(String nameJob,Long idJobOffer){
        Notification notification=new Notification();
        notification.setNameEmployment(nameJob);
        notification.setDate(new Date());
        notification.setMessage("Se creo una oferta de trabajo disponible para usted, IdJobOffer N°"+idJobOffer);
        notificationRepository.save(notification);
    }
    public List<Notification>findAllNotification(){
        return notificationRepository.findAll();
    }
}
