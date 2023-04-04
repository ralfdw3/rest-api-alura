package med.voll.api.domain.consulta.validacoes;

import med.voll.api.domain.ValidacaoException;
import med.voll.api.domain.consulta.DadosAgendamentoConsulta;
import org.springframework.stereotype.Component;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDateTime;
@Component
public class ValidadorHorarioAntecedencia implements ValidadorAgendamentoDeConsulta{

    public void validar(DadosAgendamentoConsulta dados){

        LocalDateTime dataConsulta = dados.data();
        LocalDateTime now = LocalDateTime.now();
        Long diff = Duration.between(now, dataConsulta).toMinutes();

        if (diff < 30){
            throw new ValidacaoException("Consulta deve ser agendada com antecedência de 30 minutos.");
        }
    }
}
