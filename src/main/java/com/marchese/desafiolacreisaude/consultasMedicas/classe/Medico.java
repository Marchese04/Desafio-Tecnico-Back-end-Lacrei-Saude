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

    /*aqui temos uma classe basica com id, nome, endereço e etc, o id server pra diser que aquele paremtro e o id e o generatedvalue serve para gerar um
    * numero a cada medico criado, e o que esta dentro dos "()" server pra dizer que ira ser um identificador unico e não gerar o mesmo numero mesmo que
    * tenha sido apagado, por exemplo, o usuario 3 foi apagado e você cria outro, ele nunca vai ser o 3, sempre ira ser o proximo numero*/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    /*o column server parea dizer que isso sera uma coluna no nosso banco de dados e o false diz que ele não pode estar vazia*/
    @Column(nullable = false)
    String name;

    @Column(nullable = false)
    String profissao;

    @Column(nullable = false)
    String endereco;

    @Column(nullable = false)
    int numeroDeContato;

    /*utilizamos o OffsetDataTime pra data e hora */
    @Column(name = "created_at")
    private OffsetDateTime createdAT;

    /*aqui temos um metodo que sempre que o createdAT for mensionado ele salvar a data e hora que o objeto medico foi criado no nosso banco de dados*/
    @PrePersist
    protected void onCreate(){
        this.createdAT = OffsetDateTime.now();
    }
}
