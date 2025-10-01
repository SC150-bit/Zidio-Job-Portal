
package com.zidio.zidioconnect.controller;

import com.zidio.zidioconnect.model.ApplicationEntity;
import com.zidio.zidioconnect.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/applications")
@CrossOrigin(origins = "*")
public class ApplicationController {
    @Autowired private ApplicationService appService;

    @PostMapping("/apply")
    public ApplicationEntity apply(@RequestBody ApplicationEntity app) { return appService.apply(app); }

    @GetMapping("/student/{id}")
    public List<ApplicationEntity> byStudent(@PathVariable Long id) { return appService.byStudent(id); }

    @GetMapping("/job/{id}")
    public List<ApplicationEntity> byJob(@PathVariable Long id) { return appService.byJob(id); }
}
