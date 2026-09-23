package com.marchese.desafiolacreisaude.consultasMedicas.dto;

import java.time.OffsetDateTime;

public record MedicoResponseDTO(Long id, String name, OffsetDateTime createdAT) {
}
