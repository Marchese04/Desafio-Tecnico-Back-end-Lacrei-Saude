package com.marchese.desafiolacreisaude.consultasMedicas.service;

import com.marchese.desafiolacreisaude.consultasMedicas.classe.Medico;
import com.marchese.desafiolacreisaude.consultasMedicas.dto.MedicoRequestDTO;
import com.marchese.desafiolacreisaude.consultasMedicas.dto.MedicoResponseDTO;
import com.marchese.desafiolacreisaude.consultasMedicas.mapper.MedicoMapper;
import com.marchese.desafiolacreisaude.consultasMedicas.repository.MedicoRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class MedicoService {

    //aqui estou declarando as classes para que eu possa utiliza-las
    private MedicoRepository medicoRepository;
    private MedicoMapper medicoMapper;

    //aqui estou criando os construtores
    public MedicoService(MedicoMapper medicoMapper, MedicoRepository medicoRepository){
        this.medicoMapper = medicoMapper;
        this.medicoRepository =medicoRepository;
    }

    /*Importante observar que eu estou instanciando a classe usando o "P" maiusculo ao inves de minuscolo porque estamos
    * mencionando diretamente a classe e não um metodo já que lá na camada mapper eu declarei ela como "static".
    * Aqui eu estou fazendo o metodo para poder criar o medico, primeiro acessamos o metodo do mapper que criamos, depois
    * usamos o ".save" do Jpa que a camada Repository esta extendendo para criar a classe, e depois ele retorna as informações
    * pedem no desafio para passar*/
    public MedicoResponseDTO criarMedico(MedicoRequestDTO medicoRequestDTO){
        Medico medico = MedicoMapper.toEntity(medicoRequestDTO);
        medico = medicoRepository.save(medico);
        return MedicoMapper.toResponseDTO(medico);
    }

    /*Aqui estou fazendo o metodo para mostrar os medicos, primeiro eu uso uma lista e instancio o dto responsavel por exibir as informações
    * depois eu declaro essa lista e uso otro metodo do Jpa que seria o ".findAll" que já me mostra todos da lista, o ".stream" pega toda a lista
    * e transforma em uma stream meio que faz um fluxo automatico, depois o ".map" para cada objeto que passa pelo steam ele acessa o mapper e aplica
    * o toResponse que seria nosso metodo que exibe somente as informações pedidas e transformando em um "MedicoRespondeDTO" e por ultimo o ".collect"
    * ele pega esse processo e transforma em uma lista*/
    public List<MedicoResponseDTO> mostraMedicos(){
        List<Medico> medicoList = medicoRepository.findAll();
        return medicoList.stream()
                .map(MedicoMapper :: toResponseDTO)
                .collect(Collectors.toList());
    }
    /*Bom, aqui eu fiz um metodo para mostrar o metodo pelo id, o optional serve para pegar ou não o medico pelo id, a magica tá no return
    * no return usamos mais uma vez o ".map" que eu expliquei no comentario de cima, e aqui temos o ".orElseThrow" que serve para caso o
    * optional não pegue ninguem ele ira exibir um erro na requisição e não apenas um vazio */
    public MedicoResponseDTO mostraMedicosId (Long id){
        Optional<Medico> medicoPeloId = medicoRepository.findById(id);
        return medicoPeloId.map(MedicoMapper ::toResponseDTO) .orElseThrow();
    }
    /*aqui estou fazendo o metodo para deletar o usuario pelo id, primeiro faço uma validação para verificar se o medico existe
    * depois caso o medico não exista ele exibira a mensagem de erro e caso ele exista ele ira ser deletado*/
    public void deletById(Long id){
        Optional<Medico> exististeMedico = medicoRepository.findById(id);
        exististeMedico.orElseThrow();
        medicoRepository.deleteById(id);
    }

    /*esse aqui foi dificil kkkkkk, minha primeira vez fazendo um metodo de atualização usando records, mas aqui eu declaro por onde vamos pegar os dados
    * "MedicoRespondeDTO" depois dou o nome do metodo e os parametros utilizados, o Long e id e depois o DTO que usamos para criar os objetos, dai,
    * fazemos um optiona que checa se o id tem um objeto alocado a ele no banco de dados  e depois declaramos esse objeto com uma nova variavel e um
    * ".orElseThrow" que caso não exista o objeto ele já ira dar erro, depois eu faço varios "if" para que eu possa verificar se o usuario esta passando
    * algum dado ou não, se sim ele ira mudar o dado que ja existe pra esse novo, se não ele só pula pro proximo basicamente "se for diferente faça isso",
    * por fim eu pego esse novo objeto e salvo e depois uso o metodo do mapper que fizemos para exibir as informações que o desafio pedia para exibir*/
    public MedicoResponseDTO alterarDados (Long id, MedicoRequestDTO medicoRequestDTO) {
        Optional<Medico> medicoExiste = medicoRepository.findById(id);
        Medico novoMedico = medicoExiste.orElseThrow();
        if (medicoRequestDTO.numeroDeContato() != null) {
            novoMedico.setNumeroDeContato(medicoRequestDTO.numeroDeContato());
        }
        if (medicoRequestDTO.name() != null) {
            novoMedico.setName(medicoRequestDTO.name());
        }
        if (medicoRequestDTO.profissao() != null) {
            novoMedico.setProfissao(medicoRequestDTO.profissao());
        }
        if (medicoRequestDTO.endereco() != null) {
            novoMedico.setEndereco(medicoRequestDTO.endereco());
        }
        novoMedico = medicoRepository.save(novoMedico);
        return MedicoMapper.toResponseDTO(novoMedico);
    }
}
