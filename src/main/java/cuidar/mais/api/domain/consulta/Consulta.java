package cuidar.mais.api.domain.consulta;

import cuidar.mais.api.domain.medico.Medico;
import cuidar.mais.api.domain.paciente.Paciente;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jdk.jfr.Name;
import lombok.*;

import java.time.LocalDateTime;

@Entity(name = "Consulta")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "consultas")
@EqualsAndHashCode(of = "id")
public class Consulta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "medico_id")
    private Medico medico;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "paciente_id")
    private Paciente paciente;

    private LocalDateTime data;

    @Column(name = "motivo_cancelamento")
    @Enumerated(EnumType.STRING)
    private MotivoCancelamento motivoCancelamento;


    public void cancelar(@NotNull MotivoCancelamento motivo) {
        this.motivoCancelamento = motivo;
    }
}
