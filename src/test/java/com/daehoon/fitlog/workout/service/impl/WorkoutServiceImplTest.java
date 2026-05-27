package com.daehoon.fitlog.workout.service.impl;

import com.daehoon.fitlog.workout.domain.Workout;
import com.daehoon.fitlog.workout.repository.impl.WorkoutRepositoryImpl;
import com.daehoon.fitlog.workout.service.WorkoutService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WorkoutServiceImplTest {

    private WorkoutService workoutService = new WorkoutServiceImpl(new WorkoutRepositoryImpl());

    @BeforeEach
    void setUp() {
        workoutService.clearStore();
    }

    @Test
    void save() {
        // given
        Workout workout = new Workout();
        workoutService.save(workout);

        // when
        Workout saveWorkout = workoutService.findById(workout.getId());

        // then
        Assertions.assertThat(workout).isSameAs(saveWorkout);
    }

    @Test
    void findById() {
        // given
        Workout workout = new Workout();
        workoutService.save(workout);

        // when
        Workout saveWorkout = workoutService.findById(workout.getId());

        // then
        Assertions.assertThat(workout).isSameAs(saveWorkout);

    }
}