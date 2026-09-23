package com.marchese.desafiolacreisaude.consultasMedicas.dto;

import jakarta.validation.constraints.NotBlank;

import java.time.OffsetDateTime;

public record MedicoRequestDTO(@NotBlank String name, @NotBlank String profissao,@NotBlank String endereco, @NotBlank int numeroDeContato) {
}
