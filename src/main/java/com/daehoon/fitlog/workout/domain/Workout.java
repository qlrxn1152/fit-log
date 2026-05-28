package com.daehoon.fitlog.workout.domain;

import com.daehoon.fitlog.workout.domain.exercises.Exercises;

import java.time.LocalDateTime;
import java.util.Map;

public class Workout {

    private Long id;
    private Long memberId;

    private Integer calories;

    private LocalDateTime workoutAt;
    private Map<Target, Exercises> exercises;
}
