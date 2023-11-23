package com.project.ReDeAmericaBE.repositories;

import com.project.ReDeAmericaBE.entities.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface iCountryRepository extends JpaRepository<Country,Integer>{
}
