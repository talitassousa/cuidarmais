package cuidar.mais.api.dto;

import cuidar.mais.api.endereco.Endereco;
import cuidar.mais.api.medico.Medico;
import cuidar.mais.api.paciente.Paciente;

public record DadosDetalhamentoPaciente(

        Long id,
        String nome,
        String email,
        String telefone,
        String cpf,
        Endereco endereco
) {

    public DadosDetalhamentoPaciente(Paciente paciente){
        this(paciente.getId(), paciente.getNome(), paciente.getTelefone(), paciente.getEmail(), paciente.getCpf(), paciente.getEndereco());
    }
}
