package cuidar.mais.api.dto;

import cuidar.mais.api.endereco.Endereco;
import cuidar.mais.api.medico.Especialidade;
import cuidar.mais.api.medico.Medico;

public record DadosDetalhamentoMedico(
        Long id,
        String nome,
        String telefone,
        String email,
        String crm,
        Especialidade especialidade,
        Endereco endereco)
{
    public DadosDetalhamentoMedico(Medico medico){
        this(medico.getId(), medico.getNome(), medico.getTelefone(), medico.getEmail(), medico.getCrm(), medico.getEspecialidade(),medico.getEndereco());
    }

}
