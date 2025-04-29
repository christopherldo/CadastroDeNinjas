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

@Entity
@Table(name = "ninjas")
public class NinjaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String name;
    private String email;
    private LocalDate birthDate;

    @ManyToMany
    private List<MissionModel> missions;

    protected NinjaModel() {}

    public NinjaModel(String name, String email, LocalDate birthDate) {
        this.name = name;
        this.email = email;
        this.birthDate = birthDate;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public int getIdade() {
        if (this.birthDate == null) {
            throw new IllegalStateException("Data de nascimento não definida para calcular a idade.");
        }
        
        LocalDate dataAtual = LocalDate.now(ZoneId.systemDefault());
        Period periodo = Period.between(this.birthDate, dataAtual);
        return periodo.getYears();
    }

    public List<MissionModel> getMissions() {
        return missions;
    }

    @Override
    public String toString() {
        return "NinjaModel [id=" + id + ", name=" + name + ", email=" + email + ", birthDate=" + birthDate + "]";
    }
}
