package com.daehoon.fitlog.workout.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;

@Getter @ToString @Slf4j @EqualsAndHashCode
public class Workout {

    private Long id;
    private String targetName;
    private Integer calories;
    private LocalDateTime workoutAt;

    public void setId(Long id) {
        this.id = id;
    }

}
