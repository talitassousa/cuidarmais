package cuidar.mais.api.dto;

import cuidar.mais.api.domain.consulta.MotivoCancelamento;
import jakarta.validation.constraints.NotNull;

public record DadosCancelamentoConsulta(

        @NotNull
        Long idConsulta,

        @NotNull
        MotivoCancelamento motivo
) {
}
