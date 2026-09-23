package com.marchese.desafiolacreisaude.consultasMedicas.mapper;

import com.marchese.desafiolacreisaude.consultasMedicas.classe.Medico;
import com.marchese.desafiolacreisaude.consultasMedicas.dto.MedicoRequestDTO;
import com.marchese.desafiolacreisaude.consultasMedicas.dto.MedicoResponseDTO;

public class MedicoMapper {

    public static Medico toEntity (MedicoRequestDTO medicoRequestDTO){
        Medico medico = new Medico();
        medico.setName(medicoRequestDTO.name());
        medico.setProfissao(medicoRequestDTO.profissao());
        medico.setEndereco(medicoRequestDTO.endereco());
        medico.setNumeroDeContato(medicoRequestDTO.numeroDeContato());

        return medico;
    }

    public MedicoResponseDTO toResponseDTO(Medico medico) {
        MedicoResponseDTO medicoResponseDTO = new MedicoResponseDTO(
                medico.getId(), medico.getName(), medico.getCreatedAT());
        return medicoResponseDTO;
    }

}
