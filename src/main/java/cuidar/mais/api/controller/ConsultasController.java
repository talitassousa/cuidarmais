package cuidar.mais.api.controller;


import cuidar.mais.api.dto.DadosAgendamentoConsulta;
import cuidar.mais.api.dto.DadosCancelamentoConsulta;
import cuidar.mais.api.service.AgendarConsultasService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("consultas")
@SecurityRequirement(name = "bearer-key")
public class ConsultasController {

    @Autowired
    private AgendarConsultasService agenda;

    @PostMapping
    private ResponseEntity agendar(@RequestBody @Valid DadosAgendamentoConsulta dados) {

        var dto = agenda.agendar(dados);

        return ResponseEntity.ok(dto);
    }

    @DeleteMapping
    private ResponseEntity cancelar(@RequestBody @Valid DadosCancelamentoConsulta dados) {

        agenda.cancelar(dados);

        return ResponseEntity.noContent().build();
    }

}
