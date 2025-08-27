package cuidar.mais.api.dto;

import cuidar.mais.api.domain.endereco.Endereco;
import cuidar.mais.api.domain.medico.Especialidade;
import cuidar.mais.api.domain.medico.Medico;

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
        this(medico.getId(), medico.getNome(), medico.getEmail(),medico.getTelefone(), medico.getCrm(), medico.getEspecialidade(),medico.getEndereco());
    }

}
