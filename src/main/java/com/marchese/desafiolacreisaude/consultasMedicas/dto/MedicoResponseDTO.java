package com.marchese.desafiolacreisaude.consultasMedicas.dto;

import java.time.OffsetDateTime;
/*aqui eu declaro apenas as coisas que eu quero que mostre quando alguem fizer uma requisição no banco de dados*/
public record MedicoResponseDTO(Long id, String name, OffsetDateTime createdAT) {
}
