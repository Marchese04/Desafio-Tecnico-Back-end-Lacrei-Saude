package com.marchese.desafiolacreisaude.consultasMedicas.dto;

import jakarta.validation.constraints.NotBlank;

/*Caso você tenha visto meu ultimo commit ira perceber que o meu numero pra contato era um int e eu mudei para um interger por conta de
* um metodo que eu to criando para alterar os dados dos usuarios, então teria um problema eu manter o int porque ele ira sempre substituir o numero por zero*/

//aqui eu declaro o que o usuario ira poder passar na criação de um medico e o notblank serve pra não permitir respostas vazias
public record MedicoRequestDTO(@NotBlank String name, @NotBlank String profissao,@NotBlank String endereco, @NotBlank Integer numeroDeContato) {
}
