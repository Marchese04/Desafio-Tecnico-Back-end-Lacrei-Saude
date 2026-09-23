package com.marchese.desafiolacreisaude.consultasMedicas.dto;

import java.time.OffsetDateTime;

public record MedicoRequestDTO(String name, String profissao, String endereco, int numeroDeContato) {
}
