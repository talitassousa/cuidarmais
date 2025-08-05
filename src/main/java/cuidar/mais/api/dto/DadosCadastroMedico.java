package cuidar.mais.api.dto;

import cuidar.mais.api.domain.medico.Especialidade;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DadosCadastroMedico(

        @NotBlank(message = "Nome é obrigatório")
        String nome,

        @NotBlank(message = "Email é obrigatório")
        @Email
        String email,

        @NotBlank(message = "Telefone é obrigatório")
        String telefone,

        @NotBlank(message = "CRM é obrigatório")
        @Pattern(regexp = "\\d{4,6}")
        String crm,

        @NotNull(message = "Especialidade é obrigatório")
        Especialidade especialidade,

        @NotNull(message = "Dados do endereço são obrigatórios")
        DadosEndereco endereco) {
}
