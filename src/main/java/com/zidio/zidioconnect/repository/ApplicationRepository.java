
package com.zidio.zidioconnect.repository;

import com.zidio.zidioconnect.model.ApplicationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ApplicationRepository extends JpaRepository<ApplicationEntity, Long> {
    List<ApplicationEntity> findByStudentId(Long studentId);
    List<ApplicationEntity> findByJobId(Long jobId);
}
