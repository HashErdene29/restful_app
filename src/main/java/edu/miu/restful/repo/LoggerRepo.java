package edu.miu.restful.repo;

import edu.miu.restful.entity.Logger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

public interface LoggerRepo extends JpaRepository<Logger, Integer> {
    @Modifying
    @Query("UPDATE Logger p set p.operation = :operation where p.id = :id")
    int updateOperationsById(@Param("id") int id, @Param("operation") String operation);
}
