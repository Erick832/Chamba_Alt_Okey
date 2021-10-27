package com.example.demo.repositories;

import com.example.demo.entities.Employee;
import com.example.demo.entities.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotificationRepository extends JpaRepository<Notification,Long> {
    @Query("SELECT no FROM Notification no WHERE no.nameEmployment=?1")
    List<Notification> queryFiltrarNotificationByNamejob(String nameEmploiment);
}
