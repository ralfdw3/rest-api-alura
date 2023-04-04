package med.voll.api.domain.consulta.validacoes;

import med.voll.api.domain.ValidacaoException;
import med.voll.api.domain.consulta.DadosAgendamentoConsulta;
import org.springframework.stereotype.Component;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
@Component
public class ValidadorHorarioFuncionamentoClinica  implements ValidadorAgendamentoDeConsulta{

    public void validar(DadosAgendamentoConsulta dados){

        LocalDateTime dataConsulta = dados.data();
        boolean isDomingo = dataConsulta.getDayOfWeek().equals(DayOfWeek.SUNDAY);
        boolean beforeDaAberturaDaClinica = dataConsulta.getHour() < 7;
        boolean afterEncerramentoDaClinica = dataConsulta.getHour() > 18;

        if (isDomingo || beforeDaAberturaDaClinica || afterEncerramentoDaClinica){
            throw new ValidacaoException("O horário de agendamento de consulta é de segunda a sábado, das 8 as 16h.");
        }

    }
}
