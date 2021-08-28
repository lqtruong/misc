package com.turong.training.webflux.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;


@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@Accessors(chain = true)
@Table("users")
public class User {

    @Id
    private Long id;
    private String username;
    private String email;
    private String tenant;

    @CreatedDate
    private LocalDate createdAt;

    @LastModifiedDate
    private LocalDate modifiedAt;

}
