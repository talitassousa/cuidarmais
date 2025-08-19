package cuidar.mais.api.validacoes.agendamento;

import cuidar.mais.api.dto.DadosAgendamentoConsulta;
import cuidar.mais.api.exception.ValidacaoException;
import cuidar.mais.api.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorPacienteAtivo implements ValidadorAgendamentoDeConsulta {

    @Autowired
    private PacienteRepository repository;

    public void validar(DadosAgendamentoConsulta dados) {

        var pacienteAtivo = repository.findAtivoById(dados.idPaciente());

        if (!pacienteAtivo) {
            throw new ValidacaoException("Consulta não pode ser agendada com um paciente excluido!");
        }
    }
}
