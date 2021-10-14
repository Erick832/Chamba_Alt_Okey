package com.example.demo.dto;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class JobRequest {
    @NotNull
    private String nameJob;
    @NotNull
    private String typeJob;
}
