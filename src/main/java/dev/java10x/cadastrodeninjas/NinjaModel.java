package dev.java10x.cadastrodeninjas;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "ninjas")
public class NinjaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String nome;
    private String email;
    private LocalDate birthDate;

    public NinjaModel() {}

    public NinjaModel(String nome, String email, LocalDate birthDate) {
        this.nome = nome;
        this.email = email;
        this.birthDate = birthDate;
    }

    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    @Override
    public String toString() {
        return "NinjaModel{" +
               "id='" + id + '\'' +
               ", nome='" + nome + '\'' +
               ", email='" + email + '\'' +
               ", birthDate=" + birthDate +
               '}';
    }
}
