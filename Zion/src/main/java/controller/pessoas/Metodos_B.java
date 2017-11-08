package controller.pessoas;

import java.text.ParseException;

import adaptadores.TextFieldFormatter;
import model.entities.Pessoa;
import model.enums.Enum_Aux_Mascaras;
import model.enums.Enum_Aux_Sexo;
import model.enums.Enum_Aux_Tipo_Pessoa;
import util.Utilidades;

public class Metodos_B extends Metodos_C {

	public Pessoa CarregaControlesVisuaisPessoa(boolean carregar, Pessoa p) {
		if (carregar) {
			if (p != null) {
				if (p.getEnum_Aux_Tipo_Pessoa() != null)
					cb_Tipo_Pessoa.getSelectionModel().select(p.getEnum_Aux_Tipo_Pessoa());
				else
					cb_Tipo_Pessoa.getSelectionModel().select(Enum_Aux_Tipo_Pessoa.FISICA);
				if (p.getSexo() != null)
					cb_Sexo.getSelectionModel().select(p.getSexo());
				else
					cb_Sexo.getSelectionModel().select(Enum_Aux_Sexo.MASCULINO);

				tf_Cpf_Cnpj.setText(p.getCpf_Cnpj());
				if (p.getId() != null && p.getId() > 0)
					tf_Id.setText("" + p.getId());
				else
					tf_Id.setText("");

				tf_Nome_Razao_Social.setText(p.getDescricao());
				tf_Fantasia_Apelido.setText(p.getFantasia_Apelido());
				if (p.getId_Pessoa_Registro() != null)
					tf_Resp_Registro.setText(p.getId_Pessoa_Registro().getDescricao());
				else
					tf_Resp_Registro.setText("");

				tf_Rg_Inscricao_Estadual.setText(p.getRg_Insc());
				if (p.getUltimaAtualizacao() != null)
					try {
						tf_Ultima_Alteracao.setText(Utilidades.transformaDataEmString(p.getUltimaAtualizacao(), true));
					} catch (ParseException e) {

						e.printStackTrace();
					}
				else
					tf_Ultima_Alteracao.setText("");
				if (p.getDataNascimento() != null)
					dp_Data_Nascimento_Abertura
							.setValue(Utilidades.transformaDataEmFormatoLocal(p.getDataNascimento()));
				else
					dp_Data_Nascimento_Abertura
							.setValue(Utilidades.transformaDataEmFormatoLocal(Utilidades.retornaCalendario2()));

			} else {

				cb_Tipo_Pessoa.getSelectionModel().select(Enum_Aux_Tipo_Pessoa.FISICA);

				tf_Cpf_Cnpj.setText("");
				;
				tf_Id.setText("");
				tf_Nome_Razao_Social.setText("");
				tf_Fantasia_Apelido.setText("");
				tf_Resp_Registro.setText("");
				tf_Rg_Inscricao_Estadual.setText("");
				tf_Ultima_Alteracao.setText("");
				dp_Data_Nascimento_Abertura
						.setValue(Utilidades.transformaDataEmFormatoLocal(Utilidades.retornaCalendario2()));
			}

		} else {
			p.setSexo(cb_Sexo.getValue());
			p.setEnum_Aux_Tipo_Pessoa(cb_Tipo_Pessoa.getValue());
			p.setCpf_Cnpj(tf_Cpf_Cnpj.getText());
			p.setDescricao(tf_Nome_Razao_Social.getText());
			p.setFantasia_Apelido(tf_Fantasia_Apelido.getText());
			p.setRg_Insc(tf_Rg_Inscricao_Estadual.getText());
			p.setDataNascimento(Utilidades.transformaFormatoLocalEmData(dp_Data_Nascimento_Abertura.getValue()));
		}
		return p;
	}
	public void formatDataPicker() {
		TextFieldFormatter formatter = new TextFieldFormatter(dp_Data_Nascimento_Abertura);
		formatter.setMask(Enum_Aux_Mascaras.DATABARRA);
		formatter.showMask();
	}
	
	
	
	

}
