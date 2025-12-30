package com.example.repository;

import com.example.entity.Record;
import com.example.entity.RecordStatus;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface RecordRepository extends JpaRepository<Record, Integer> {

    @Modifying
    @Query("UPDATE Record SET status = :status WHERE id = :id")
    void update(int id, @Param("status") RecordStatus newStatus);

}