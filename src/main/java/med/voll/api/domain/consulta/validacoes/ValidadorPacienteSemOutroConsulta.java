package med.voll.api.domain.consulta.validacoes;

import med.voll.api.domain.ValidacaoException;
import med.voll.api.domain.consulta.ConsultaRepository;
import med.voll.api.domain.consulta.DadosAgendamentoConsulta;
import org.hibernate.annotations.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
@Component
public class ValidadorPacienteSemOutroConsulta implements ValidadorAgendamentoDeConsulta {

    @Autowired
    private ConsultaRepository repository;

    public void validar(DadosAgendamentoConsulta dados){

        LocalDateTime inicioExpediente = dados.data().withHour(7);
        LocalDateTime finalExpediente = dados.data().withHour(18);

        boolean pacientePossuiOutraConsultaNoMesmoDia = repository.existsByPacienteIdAndDataBetween(dados.idPaciente(), inicioExpediente, finalExpediente);

        if (pacientePossuiOutraConsultaNoMesmoDia){
            throw new ValidacaoException("O paciente já possui uma consulta neste dia.");
        }
    }
}
