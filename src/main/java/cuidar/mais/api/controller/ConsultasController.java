package cuidar.mais.api.controller;


import cuidar.mais.api.dto.DadosAgendamentoConsulta;
import cuidar.mais.api.dto.DadosCancelamentoConsulta;
import cuidar.mais.api.dto.DadosDetalhamentoConsulta;
import cuidar.mais.api.service.AgendarConsultasService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("consultas")
public class ConsultasController {

    @Autowired
    private AgendarConsultasService agenda;

    @PostMapping
    private ResponseEntity agendar(@RequestBody @Valid DadosAgendamentoConsulta dados) {

        agenda.agendar(dados);

        return ResponseEntity.ok(new DadosDetalhamentoConsulta(null, null, null, null));
    }

    @DeleteMapping
    private ResponseEntity cancelar(@RequestBody @Valid DadosCancelamentoConsulta dados) {

        agenda.cancelar(dados);

        return ResponseEntity.noContent().build();
    }

}
