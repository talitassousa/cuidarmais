package cuidar.mais.api.dto;


import cuidar.mais.api.medico.Especialidade;
import cuidar.mais.api.medico.Medico;

public record DadosListagemMedico(
        Long id,

        String nome,

        String email,

        String crm,

        Especialidade especialidade)
{

    public DadosListagemMedico(Medico medico) {
        this(medico.getId(), medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getEspecialidade());
    }

}
