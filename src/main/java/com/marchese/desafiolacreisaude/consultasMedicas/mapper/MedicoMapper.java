package com.marchese.desafiolacreisaude.consultasMedicas.mapper;

import com.marchese.desafiolacreisaude.consultasMedicas.classe.Medico;
import com.marchese.desafiolacreisaude.consultasMedicas.dto.MedicoRequestDTO;
import com.marchese.desafiolacreisaude.consultasMedicas.dto.MedicoResponseDTO;

/*essa classe serve para fazer a conversão de DTO para nosso objeto medico e do nosso objeto medico para o DTO, como usamos record eles não possuem os getter
* e setter padrões que as classes normais de java possuim então temos que fazer dessa forma, declaramos o objeto e criamos um novo objeto e utiliza os setters
* e getters desta forma*/
public class MedicoMapper {

    public static Medico toEntity (MedicoRequestDTO medicoRequestDTO){
        Medico medico = new Medico();
        medico.setName(medicoRequestDTO.name());
        medico.setProfissao(medicoRequestDTO.profissao());
        medico.setEndereco(medicoRequestDTO.endereco());
        medico.setNumeroDeContato(medicoRequestDTO.numeroDeContato());

        return medico;
    }

    public static MedicoResponseDTO toResponseDTO (Medico medico) {
        MedicoResponseDTO medicoResponseDTO = new MedicoResponseDTO(
                medico.getId(), medico.getName(), medico.getCreatedAT());
        return medicoResponseDTO;
    }

}
