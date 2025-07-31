package cuidar.mais.api.dto;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoMedico(

        @NotNull
        Long id,

        String nome,

        String telefone,

        DadosEndereco endereco) {

//    public DadosAtualizacaoMedico(Medico medico){
//        this(medico.getId(), medico.getNome(), medico.getTelefone(), medico.getEndereco());
//    }
}
