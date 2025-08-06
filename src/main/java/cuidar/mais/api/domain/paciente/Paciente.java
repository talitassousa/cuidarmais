package cuidar.mais.api.domain.paciente;


import cuidar.mais.api.dto.DadosAtualizacaoPaciente;
import cuidar.mais.api.dto.DadosCadastroPaciente;
import cuidar.mais.api.domain.endereco.Endereco;
import jakarta.persistence.*;
import lombok.*;

@Entity(name = "Paciente")
@Table(name = "pacientes")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String email;
    private String telefone;
    private String cpf;


    @Embedded
    private Endereco endereco;

    private Boolean ativo;

    public Paciente(DadosCadastroPaciente dados) {
        this.ativo = true;
        this.nome = dados.nome();
        this.email = dados.email();
        this.telefone = dados.telefone();
        this.cpf = dados.cpf();
        this.endereco = new Endereco(dados.endereco());
    }


    public void atualizarInformacoes(DadosAtualizacaoPaciente dados) {
        if (dados.nome() != null)
            this.nome = dados.nome();

        if(dados.telefone() != null)
            this.telefone = dados.telefone();

        if(dados.endereco() != null)
            endereco.atualizarInformacoes(dados.endereco());
    }

    public void excluir() {
        this.ativo = false;
    }
}
