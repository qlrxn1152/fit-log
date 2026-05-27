package com.daehoon.fitlog.workout.service.impl;

import com.daehoon.fitlog.workout.domain.Workout;
import com.daehoon.fitlog.workout.repository.WorkoutRepository;
import com.daehoon.fitlog.workout.service.WorkoutService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
@Slf4j
public class WorkoutServiceImpl implements WorkoutService {

    private final WorkoutRepository workoutRepository;

    @Override
    public Workout save(Workout workout) {
        return workoutRepository.save(workout);
    }

    @Override
    public Workout findById(Long id) {
        return workoutRepository.findById(id);
    }

    @Override
    public void clearStore() {
        workoutRepository.clearStore();
    }
}
