package cuidar.mais.api.validacoes.cancelamento;

import cuidar.mais.api.dto.DadosCancelamentoConsulta;
import cuidar.mais.api.infra.exception.ValidacaoException;
import cuidar.mais.api.repository.ConsultaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;

@Component("ValidadorHorarioAntecedenciaCancelamento")
public class ValidadorHorarioAntecedencia  implements ValidadorCancelamentoDeConsulta{

    @Autowired
    private ConsultaRepository repository;


    @Override
    public void validar(DadosCancelamentoConsulta dados) {
        var consulta = repository.getReferenceById(dados.idConsulta());
        var agora = LocalDateTime.now();
        var diferencaEmHoras = Duration.between(agora, consulta.getData()).toHours();

        if (diferencaEmHoras < 24) {
            throw new ValidacaoException("Consulta so pode ser cancelada com antecedência mínima de 24h!");
        }
    }
}
