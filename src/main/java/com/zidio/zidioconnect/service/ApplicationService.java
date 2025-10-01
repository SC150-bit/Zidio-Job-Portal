
package com.zidio.zidioconnect.service;

import com.zidio.zidioconnect.model.ApplicationEntity;
import com.zidio.zidioconnect.repository.ApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplicationService {
    @Autowired private ApplicationRepository repo;

    public ApplicationEntity apply(ApplicationEntity app) { return repo.save(app); }
    public List<ApplicationEntity> byStudent(Long studentId) { return repo.findByStudentId(studentId); }
    public List<ApplicationEntity> byJob(Long jobId) { return repo.findByJobId(jobId); }
}
