package cuidar.mais.api.controller;


import cuidar.mais.api.dto.DadosAtualizacaoPaciente;
import cuidar.mais.api.dto.DadosCadastroPaciente;
import cuidar.mais.api.dto.DadosListagemPaciente;
import cuidar.mais.api.paciente.Paciente;
import cuidar.mais.api.repository.PacienteRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("pacientes")
public class PacienteController {

    @Autowired
    private PacienteRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroPaciente dados) {
       repository.save(new Paciente(dados));
    }

    @GetMapping
    public Page<DadosListagemPaciente> listar(@PageableDefault(page = 0, size = 10) Pageable paginacao) {
        return repository.findAllByAtivoTrue(paginacao).map(DadosListagemPaciente::new);
    }


    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizacaoPaciente dados) {
        var paciente = repository.getReferenceById(dados.id());
        paciente.atualizarInformacoes(dados);
    }


    @DeleteMapping
    @Transactional
    public void remover(@PathVariable Long id) {
        var paciente = repository.getReferenceById(id);
        paciente.inativar();
    }
}
