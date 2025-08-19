package cuidar.mais.api.validacoes.agendamento;

import cuidar.mais.api.dto.DadosAgendamentoConsulta;
import cuidar.mais.api.exception.ValidacaoException;
import cuidar.mais.api.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorMedicoAtivo implements ValidadorAgendamentoDeConsulta {

    @Autowired
    private MedicoRepository repository;

    public void validar (DadosAgendamentoConsulta dados) {

        // A escolha do médico é opcional
        if (dados.idMedico() == null){
            return;
        }

        var medicoEstaAtivo = repository.findAtivoById(dados.idMedico());

        if (!medicoEstaAtivo) {
            throw new ValidacaoException("Consulta não pode ser agendada com um médico excluido!");
        }
    }
}
