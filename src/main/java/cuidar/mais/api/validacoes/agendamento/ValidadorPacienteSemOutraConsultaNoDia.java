package cuidar.mais.api.validacoes.agendamento;

import cuidar.mais.api.dto.DadosAgendamentoConsulta;
import cuidar.mais.api.infra.exception.ValidacaoException;
import cuidar.mais.api.repository.ConsultaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorPacienteSemOutraConsultaNoDia implements ValidadorAgendamentoDeConsulta {

    @Autowired
    private ConsultaRepository repository;

    public void validar(DadosAgendamentoConsulta dados) {

        var primeiroHorario = dados.data().withHour(7);
        var ultimoHorario = dados.data().withHour(18);
        var pacientePossuiConsultaNoDia = repository.existsByPacienteIdAndDataBetween(dados.idPaciente(), primeiroHorario, ultimoHorario);

        if (pacientePossuiConsultaNoDia) {
            throw new ValidacaoException("Paciente já possui consulta agendada nesse dia");
        }

    }
}
