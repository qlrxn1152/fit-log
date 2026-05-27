package com.daehoon.fitlog.workout.repository.impl;

import com.daehoon.fitlog.workout.domain.Workout;
import com.daehoon.fitlog.workout.repository.WorkoutRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
@Slf4j
public class WorkoutRepositoryImpl implements WorkoutRepository {

    private final Map<Long, Workout> store = new HashMap<>();
    private Long sequence = 0L;


    @Override
    public Workout save(Workout workout) {
        workout.setId(++sequence);
        store.put(workout.getId(), workout);
        return workout;
    }

    @Override
    public Workout findById(Long id) {
        return store.get(id);
    }

    @Override
    public void clearStore() {
        store.clear();
    }
}
