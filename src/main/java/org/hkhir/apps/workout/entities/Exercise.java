package org.hkhir.apps.workout.entities;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "EXCERCISE")
public class Exercise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @OneToMany(mappedBy = "exercise", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ExerciseSet> sets;

    @OneToOne
    private ExerciseSet personalBest;

    public Exercise() {
    }

    private Exercise(ExerciseBuilder builder) {
        this.name = builder.name;
        this.sets = builder.sets;
        this.personalBest = builder.personalBest;
    }

    public static class ExerciseBuilder {

        private final String name;
        private final List<ExerciseSet> sets;
        private ExerciseSet personalBest;

        public ExerciseBuilder(String name, List<ExerciseSet> sets) {

            this.name = name;
            this.sets = sets;
        }

        public ExerciseBuilder setPersonalBest(ExerciseSet personalBest) {

            this.personalBest = personalBest;
            return this;
        }

        public Exercise build() {

            return new Exercise(this);
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

    public List<ExerciseSet> getSets() {
        return sets;
    }

    public void setSets(List<ExerciseSet> sets) {
        this.sets = sets;
    }

    public ExerciseSet getPersonalBest() {
        return personalBest;
    }

    public void setPersonalBest(ExerciseSet personalBest) {
        this.personalBest = personalBest;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Exercise exercise = (Exercise) o;
        return id == exercise.id && Objects.equals(name, exercise.name) && Objects.equals(sets, exercise.sets) && Objects.equals(personalBest, exercise.personalBest);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, sets, personalBest);
    }

    @Override
    public String toString() {
        return "Exercise{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sets=" + sets +
                ", personalBest=" + personalBest +
                '}';
    }
}
