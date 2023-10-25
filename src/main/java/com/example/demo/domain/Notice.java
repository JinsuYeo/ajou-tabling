package com.example.demo.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Entity
@Getter
public class Notice {

    @Id
    @GeneratedValue
    @Column(name = "notice_id")
    private Long id;

    @NotNull
    @Column(length = 300)
    private String title;

    @NotNull
    @Column(length = 400)
    private String url;

    @NotNull
    @Column(name = "created_at", length = 100)
    private String createdAt;
}
