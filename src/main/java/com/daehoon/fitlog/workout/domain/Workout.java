package com.daehoon.fitlog.workout.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;

@Getter @ToString @Slf4j @EqualsAndHashCode
public class Workout {

    private Long id;
    private Target target;

    private LocalDateTime workoutAt;
}
