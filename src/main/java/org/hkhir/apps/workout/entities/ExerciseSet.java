package org.hkhir.apps.workout.entities;

import jakarta.persistence.*;
import org.hkhir.apps.workout.entities.enums.WeightUnit;

import java.util.Objects;

@Entity
@Table(name = "SET")
public class ExerciseSet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int set;

    private int reps;

    private String notes;

    private double weight;

    private WeightUnit unit;

    @ManyToOne
    @JoinColumn(name = "exercise_id")
    private Exercise exercise;

    private ExerciseSet(SetBuilder builder) {
        this.set = builder.set;
        this.reps = builder.reps;
        this.notes = builder.notes;
        this.weight = builder.weight;
        this.unit = builder.unit;
    }

    public ExerciseSet() {
    }

    public static class SetBuilder {

        private int set;
        private int reps;
        private double weight;
        private String notes;
        private WeightUnit unit = WeightUnit.LBS;

        public SetBuilder() {
        }

        public SetBuilder set(int set) {

            this.set = set;
            return this;
        }

        public SetBuilder reps(int reps) {

            this.reps = reps;
            return this;
        }

        public SetBuilder weight(double weight) {

            this.weight = weight;
            return this;
        }

        public SetBuilder units(WeightUnit unit) {

            this.unit = unit;
            return this;
        }

        public SetBuilder setNotes(String notes) {

            this.notes = notes;
            return this;
        }

        public ExerciseSet build() {

            ExerciseSet exerciseSet = new ExerciseSet();
            exerciseSet.set = this.set;
            exerciseSet.reps = this.set;
            exerciseSet.weight = this.weight;
            exerciseSet.notes = this.notes;
            exerciseSet.unit = this.unit;
            return exerciseSet;
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSet() {
        return set;
    }

    public void setSet(int set) {
        this.set = set;
    }

    public int getReps() {
        return reps;
    }

    public void setReps(int reps) {
        this.reps = reps;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public WeightUnit getUnit() {
        return unit;
    }

    public void setUnit(WeightUnit unit) {
        this.unit = unit;
    }


    public Exercise getExercise() {
        return exercise;
    }

    public void setExercise(Exercise exercise) {
        this.exercise = exercise;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExerciseSet that = (ExerciseSet) o;
        return id == that.id && set == that.set && reps == that.reps && Double.compare(weight, that.weight) == 0 && Objects.equals(notes, that.notes) && unit == that.unit && Objects.equals(exercise, that.exercise);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, set, reps, notes, weight, unit, exercise);
    }

    @Override
    public String toString() {
        return "ExerciseSet{" +
                "id=" + id +
                ", set=" + set +
                ", reps=" + reps +
                ", notes='" + notes + '\'' +
                ", weight=" + weight +
                ", unit=" + unit +
                ", exercise=" + exercise +
                '}';
    }
}
