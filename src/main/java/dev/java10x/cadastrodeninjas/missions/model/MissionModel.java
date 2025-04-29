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
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "missions")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MissionModel {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    
    private String name;
    private MissionDifficulty difficulty;

    @ManyToMany(mappedBy = "missions")
    private List<NinjaModel> ninjas;
}
