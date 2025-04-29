package dev.java10x.cadastrodeninjas.missions.model;

import java.util.List;

import dev.java10x.cadastrodeninjas.missions.enums.MissionDifficulty;
import dev.java10x.cadastrodeninjas.ninjas.model.NinjaModel;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "missions")
public class MissionModel {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    
    private String name;
    private MissionDifficulty difficulty;

    @ManyToMany(mappedBy = "missions")
    private List<NinjaModel> ninjas;

    protected MissionModel() {}

    public MissionModel(String name, MissionDifficulty difficulty) {
        this.name = name;
        this.difficulty = difficulty;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MissionDifficulty getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(MissionDifficulty difficulty) {
        this.difficulty = difficulty;
    }

    public List<NinjaModel> getNinjas() {
        return ninjas;
    }

    @Override
    public String toString() {
        return "MissionModel [id=" + id + ", name=" + name + ", difficulty=" + difficulty + "]";
    }    
}
