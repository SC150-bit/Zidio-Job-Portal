
package com.zidio.zidioconnect.dto;

import lombok.Data;

@Data
public class JobDto {
    private String title;
    private String description;
    private String location;
    private String type;
    private Long postedBy;
}
