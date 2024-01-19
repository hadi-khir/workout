package org.hkhir.apps.workout.entities;

import jakarta.persistence.*;
import org.hkhir.apps.workout.entities.enums.Location;
import org.hkhir.apps.workout.entities.enums.Mood;
import org.hkhir.apps.workout.entities.enums.MuscleGroup;

import java.util.List;
import java.util.Objects;

@Entity
public class Workout {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @ElementCollection
    private List<MuscleGroup> muscleGroups;

    @OneToMany
    private List<Exercise> exercises;

    private Location location;

    private Mood mood;

    public Workout() {
    }

    public static class WorkoutBuilder {

        private String name;
        private List<MuscleGroup> muscleGroups;
        private List<Exercise> exercises;
        private Location location;
        private Mood mood;

        public WorkoutBuilder() {
        }


        public WorkoutBuilder name(String name) {
            this.name = name;
            return this;
        }

        public WorkoutBuilder muscleGroups(List<MuscleGroup> muscleGroups) {
            this.muscleGroups = muscleGroups;
            return this;
        }

        public WorkoutBuilder exercises(List<Exercise> exercises) {
            this.exercises = exercises;
            return this;
        }

        public WorkoutBuilder location(Location location) {
            this.location = location;
            return this;
        }

        public WorkoutBuilder mood(Mood mood) {
            this.mood = mood;
            return this;
        }

        public Workout build() {
            Workout workout = new Workout();
            workout.name = this.name;
            workout.muscleGroups = this.muscleGroups;
            workout.exercises = this.exercises;
            workout.location = this.location;
            workout.mood = this.mood;
            return workout;
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<MuscleGroup> getMuscleGroups() {
        return muscleGroups;
    }

    public void setMuscleGroups(List<MuscleGroup> muscleGroups) {
        this.muscleGroups = muscleGroups;
    }

    public List<Exercise> getExercises() {
        return exercises;
    }

    public void setExercises(List<Exercise> exercises) {
        this.exercises = exercises;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Mood getMood() {
        return mood;
    }

    public void setMood(Mood mood) {
        this.mood = mood;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Workout workout = (Workout) o;
        return id == workout.id && Objects.equals(name, workout.name) && Objects.equals(muscleGroups, workout.muscleGroups) && Objects.equals(exercises, workout.exercises) && location == workout.location && mood == workout.mood;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, muscleGroups, exercises, location, mood);
    }

    @Override
    public String toString() {
        return "Workout{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", muscleGroups=" + muscleGroups +
                ", exercises=" + exercises +
                ", location=" + location +
                ", mood=" + mood +
                '}';
    }
}
