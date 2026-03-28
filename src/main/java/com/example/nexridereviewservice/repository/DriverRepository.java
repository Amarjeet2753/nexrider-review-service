package com.example.nexridereviewservice.repository;

import com.example.nexridereviewservice.entity.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface DriverRepository extends JpaRepository<Driver,Long> {

    Optional<Driver> findByIdAndLicenseNumber(Long id, String license);

    // raw sql query
    @Query(nativeQuery = true,value = "SELECT *  FROM DRIVER where id = :id  and license_number=:license")
    Optional<Driver> rawQueryfindByIdAndLicenseNumber(Long id, String license);

    //hql
    @Query("SELECT d  FROM Driver d where d.id = :id  and d.licenseNumber=:license")
    Optional<Driver> hqlFindByIdAndLicenseNumber(Long id, String license);

    List<Driver>  findAllByIdIn(List<Long> id);
}