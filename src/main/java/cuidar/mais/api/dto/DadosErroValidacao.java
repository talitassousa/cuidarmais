package cuidar.mais.api.dto;

import org.springframework.validation.FieldError;

public record DadosErroValidacao(String Campo, String mesagem) {
    public DadosErroValidacao(FieldError erro){
        this(erro.getField(), erro.getDefaultMessage());
    }
}
