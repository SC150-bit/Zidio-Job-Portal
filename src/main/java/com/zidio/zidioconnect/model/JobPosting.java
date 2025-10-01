
package com.zidio.zidioconnect.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Table(name = "jobs")
@Data
public class JobPosting {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Column(length = 5000)
    private String description;

    private String location;

    private String type; // Internship / Full-time

    private Long postedBy;

    private LocalDateTime postedAt = LocalDateTime.now();
}
