package com.daehoon.fitlog.workout.repository;

import com.daehoon.fitlog.workout.domain.Workout;

public interface WorkoutRepository {

    Workout save(Workout workout);

    Workout findById(Long id);

}
