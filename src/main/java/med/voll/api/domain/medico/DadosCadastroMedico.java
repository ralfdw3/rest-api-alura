package med.voll.api.domain.medico;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.voll.api.domain.endereco.DadosEndereco;

public record DadosCadastroMedico(
		
		@NotBlank(message = "Nome do médico é obrigatório.")
		String nome, 
		
		@NotBlank(message = "E-mail do médico é obrigatório.")
		@Email
		String email,
		
		@NotBlank(message = "Telefone do médico é obrigatório.")
		String telefone,
		
		@NotBlank(message = "CRM do médico é obrigatório.")
		@Pattern(regexp = "\\d{4,6}")
		String crm,
		
		@NotNull(message = "Especialidade do médico é obrigatória.")
		Especialidade especialidade,
		
		@NotNull(message = "Dados de endereço do médico são obrigatórios.")
		@Valid
		DadosEndereco endereco) {

}
