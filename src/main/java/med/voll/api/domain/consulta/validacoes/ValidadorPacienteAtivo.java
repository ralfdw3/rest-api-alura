package med.voll.api.domain.consulta.validacoes;

import med.voll.api.domain.ValidacaoException;
import med.voll.api.domain.consulta.DadosAgendamentoConsulta;
import med.voll.api.domain.medico.MedicoRepository;
import med.voll.api.domain.paciente.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorPacienteAtivo implements ValidadorAgendamentoDeConsulta {

    @Autowired
    private PacienteRepository repository;

    public void validar(DadosAgendamentoConsulta dados){

        if (dados.idPaciente() == null){
            return;
        }

        boolean isPacienteAtivo = repository.findAtivoById(dados.idPaciente());
        if (!isPacienteAtivo){
            throw new ValidacaoException("Consulta não pode ser agendada com paciente inativo.");
        }
    }
}
