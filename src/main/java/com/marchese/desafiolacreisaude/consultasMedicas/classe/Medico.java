package com.marchese.desafiolacreisaude.consultasMedicas.classe;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "medico")
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(nullable = false)
    String name;

    @Column(nullable = false)
    String profissao;

    @Column(nullable = false)
    String endereco;

    @Column(nullable = false)
    int numeroDeContato;

    @Column(name = "created_at")
    private OffsetDateTime createdAT;

    @PrePersist
    protected void onCreate(){
        this.createdAT = OffsetDateTime.now();
    }
}
