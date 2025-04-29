package dev.java10x.cadastrodeninjas.ninjas.model;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.List;

import dev.java10x.cadastrodeninjas.missions.model.MissionModel;
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
@Table(name = "ninjas")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class NinjaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String name;
    private String email;
    private LocalDate birthDate;

    @ManyToMany
    private List<MissionModel> missions;

    public int getIdade() {
        if (this.birthDate == null) {
            throw new IllegalStateException("Data de nascimento não definida para calcular a idade.");
        }
        
        LocalDate dataAtual = LocalDate.now(ZoneId.systemDefault());
        Period periodo = Period.between(this.birthDate, dataAtual);
        return periodo.getYears();
    }
}
