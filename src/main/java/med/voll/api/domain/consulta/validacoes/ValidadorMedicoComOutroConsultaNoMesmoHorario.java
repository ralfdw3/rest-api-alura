package med.voll.api.domain.consulta.validacoes;

import med.voll.api.domain.ValidacaoException;
import med.voll.api.domain.consulta.ConsultaRepository;
import med.voll.api.domain.consulta.DadosAgendamentoConsulta;
import med.voll.api.domain.paciente.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorMedicoComOutroConsultaNoMesmoHorario implements ValidadorAgendamentoDeConsulta {

    @Autowired
    private ConsultaRepository repository;

    public void validar(DadosAgendamentoConsulta dados){

        boolean medicoPossuiOutraConsultaNesteHorario = repository.existsByMedicoIdAndData(dados.idMedico(), dados.data());

        if (medicoPossuiOutraConsultaNesteHorario){
            throw new ValidacaoException("O doutor já possui uma consulta neste horário.");
        }
    }
}
