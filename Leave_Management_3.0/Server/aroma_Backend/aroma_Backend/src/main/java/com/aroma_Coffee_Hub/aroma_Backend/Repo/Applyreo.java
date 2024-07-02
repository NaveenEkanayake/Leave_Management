package com.aroma_Coffee_Hub.aroma_Backend.Repo;

import com.aroma_Coffee_Hub.aroma_Backend.entity.Applyleave;
import com.aroma_Coffee_Hub.aroma_Backend.entity.login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface Applyreo extends JpaRepository<Applyleave , Long> {

    int countByStatus(String status);

    @Query("SELECT COUNT(u) FROM login u WHERE u.email LIKE %:keyword%")
    int countloginByEmailContaining(@Param("keyword") String keyword);
}
