
package com.zidio.zidioconnect.repository;

import com.zidio.zidioconnect.model.JobPosting;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface JobRepository extends JpaRepository<JobPosting, Long> {
    List<JobPosting> findByPostedBy(Long recruiterId);
}
