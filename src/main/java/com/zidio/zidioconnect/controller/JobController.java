
package com.zidio.zidioconnect.controller;

import com.zidio.zidioconnect.dto.JobDto;
import com.zidio.zidioconnect.model.JobPosting;
import com.zidio.zidioconnect.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/jobs")
@CrossOrigin(origins = "*")
public class JobController {
    @Autowired private JobService jobService;

    @PostMapping("/create")
    public JobPosting create(@RequestBody JobDto dto) {
        JobPosting j = new JobPosting();
        j.setTitle(dto.getTitle());
        j.setDescription(dto.getDescription());
        j.setLocation(dto.getLocation());
        j.setType(dto.getType());
        j.setPostedBy(dto.getPostedBy());
        return jobService.create(j);
    }

    @GetMapping("/list")
    public List<JobPosting> list() { return jobService.listAll(); }

    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable Long id) {
        Optional<JobPosting> j = jobService.byId(id);
        if (j.isEmpty()) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(j.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        jobService.delete(id);
        return ResponseEntity.ok().build();
    }
}
