
package com.zidio.zidioconnect.service;

import com.zidio.zidioconnect.model.JobPosting;
import com.zidio.zidioconnect.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobService {
    @Autowired private JobRepository jobRepository;

    public JobPosting create(JobPosting j) { return jobRepository.save(j); }
    public List<JobPosting> listAll() { return jobRepository.findAll(); }
    public Optional<JobPosting> byId(Long id) { return jobRepository.findById(id); }
    public List<JobPosting> byRecruiter(Long rid) { return jobRepository.findByPostedBy(rid); }
    public void delete(Long id) { jobRepository.deleteById(id); }
}
