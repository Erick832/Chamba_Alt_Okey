package com.example.demo.repositories;

import com.example.demo.entities.JobOffer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobOfferRepository extends JpaRepository<JobOffer,Long> {
    @Query("SELECT jo FROM JobOffer jo WHERE jo.employment.name=?1")
    List<JobOffer>queryFiltrarPorNombre(String name);
    @Query("select jo from JobOffer jo Where jo.employment.type=?1")
    List<JobOffer>queryFiltrarPorTipo(String tipo);
}
