package com.example.demo.common;

import com.example.demo.dto.EmployeeResponse;
import com.example.demo.dto.EmployerResponse;
import com.example.demo.dto.JobOfferResponse;
import com.example.demo.dto.NotificationResponse;
import com.example.demo.entities.Employee;
import com.example.demo.entities.Employer;
import com.example.demo.entities.JobOffer;
import com.example.demo.entities.Notification;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class EntityDtoConverter {
    @Autowired
    private ModelMapper modelMapper;

    public NotificationResponse convertEntityToDto(Notification notification){
        return modelMapper.map(notification,NotificationResponse.class);
    }
    public List<NotificationResponse>convertNotificationsToDto(List<Notification>notifications){
        return notifications.stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());
    }

    public EmployerResponse convertEntityToDto(Employer employer){
        return modelMapper.map(employer, EmployerResponse.class);
    }
    public List<EmployerResponse>convertEmployersToDto(List<Employer> employers){
        return employers.stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());
    }

    public EmployeeResponse convertEntityToDto(Employee employee){
        return modelMapper.map(employee,EmployeeResponse.class);
    }
    public List<EmployeeResponse>convertEmployeesToDto(List<Employee>employees){
        return employees.stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());
    }

    public JobOfferResponse convertEntityToDto(JobOffer jobOffer){
        return modelMapper.map(jobOffer,JobOfferResponse.class);
    }
    public List<JobOfferResponse>convertJobOffersToDto(List<JobOffer>jobOffers){
        return jobOffers.stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());
    }


}
