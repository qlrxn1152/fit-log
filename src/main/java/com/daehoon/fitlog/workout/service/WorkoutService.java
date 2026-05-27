package com.daehoon.fitlog.workout.service;

import com.daehoon.fitlog.workout.domain.Workout;

public interface WorkoutService {

    Workout save(Workout workout);

    Workout findById(Long id);
}
