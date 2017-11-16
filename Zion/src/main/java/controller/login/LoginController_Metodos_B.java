package controller.login;

import model.dao.Pessoa_Perfil_e_VinculoDAO;
import model.entities.Pessoa_Perfil_e_Vinculo;
import model.enums.Enum_Aux_Perfil_Pessoa;
import util.Utilidades;

public class LoginController_Metodos_B extends LoginController_Metodos_C {
	protected boolean empresapossuiAlguemVinculado() {
		Pessoa_Perfil_e_VinculoDAO ppvDAO = new Pessoa_Perfil_e_VinculoDAO();
		Utilidades.getpPL().setEmpresaPossuiAlguemVinculado(
				ppvDAO.existeAlguemPerfilVinculadoAoMestre(Utilidades.getpPL().getEmpresa_Logada()));
		return Utilidades.getpPL().isEmpresaPossuiAlguemVinculado();
	}

	public Pessoa_Perfil_e_Vinculo loginContratanteOuContratado() {
		// mesmo se o login não possuir vinculo, MAS MAS MAS
		// se o login for de um contratado ou de um contratante mas onde o mesmo login D
		// seja o mesma Pessoa M ==> está tudo certo
		Pessoa_Perfil_e_Vinculo ppv = new Pessoa_Perfil_e_Vinculo();
		ppv.setId_Pessoa_D(Utilidades.getpPL().getPessoa_Logada());
		ppv.setId_Pessoa_M(Utilidades.getpPL().getEmpresa_Logada());
		Pessoa_Perfil_e_Vinculo ppv1 = new Pessoa_Perfil_e_Vinculo();
		ppv1 = ppv;
		ppv1.setEnum_Aux_Perfil_Pessoa(Enum_Aux_Perfil_Pessoa.CONTRATADOS);
		ppv1.setId_Pessoa_M(null);
		Pessoa_Perfil_e_VinculoDAO ppvDAO = new Pessoa_Perfil_e_VinculoDAO();
		ppv1 = ppvDAO.Pessoa_Perfil_e_VinculoExiste(ppv1, true, true);
		if (ppv1 != null)
			return ppv1;
		ppv1 = ppv;
		ppv1.setEnum_Aux_Perfil_Pessoa(Enum_Aux_Perfil_Pessoa.CONTRATANTES);
		ppv1.setId_Pessoa_M(null);
		ppv1 = ppvDAO.Pessoa_Perfil_e_VinculoExiste(ppv1, true, true);
		return ppv1;
	}

	public boolean usuarioEstaVinculodoAEmpresa() {
		Pessoa_Perfil_e_VinculoDAO ppvDAO = new Pessoa_Perfil_e_VinculoDAO();
		Pessoa_Perfil_e_Vinculo ppv = new Pessoa_Perfil_e_Vinculo();
		Pessoa_Perfil_e_Vinculo ppv1 = new Pessoa_Perfil_e_Vinculo();

		// se a empresa logada possui alguma pessoa vinculada a ela entra no if abaixo
		if (Utilidades.getpPL().isEmpresaPossuiAlguemVinculado()) {
			if (Utilidades.getpPL().getPessoa_Logada() != null)
				ppv.setId_Pessoa_D(Utilidades.getpPL().getPessoa_Logada());
			else
				ppv.setId_Pessoa_D(null);
			if (Utilidades.getpPL().getEmpresa_Logada() != null)
				ppv.setId_Pessoa_M(Utilidades.getpPL().getEmpresa_Logada());
			else
				ppv.setId_Pessoa_M(null);
			ppv.setEnum_Aux_Perfil_Pessoa(null);
			ppv1 = ppv;
			ppv = ppvDAO.Pessoa_Perfil_e_VinculoExiste(ppv, true, true);
			if (ppv == null) {
				ppv1 = loginContratanteOuContratado();
				if (ppv1 == null) {
					Utilidades.enviaAlertError("LOGIN", "VINCULO", "Você não está vinculoado à: "
							+ Utilidades.getpPL().getEmpresa_Logada().getFantasia_Apelido());
					return false;
				} else {
					Utilidades.getpPL().setPerfil_Logado(ppv1.getEnum_Aux_Perfil_Pessoa());
					Utilidades.getpPL().setVinculoproprio(false);
				}
			} else {
				Utilidades.getpPL().setPerfil_Logado(ppv.getEnum_Aux_Perfil_Pessoa());
				Utilidades.getpPL().setVinculoproprio(true);
			}
		}
		// caso a empresa ainda não possuia ninguém vinculoado a ela - entra nesste else
		else {
			// se a empresa logada não possui nenhum vinculo
			// preciso checar se o perfil logado é de um CONTRATADO ou da PRÓPRIA EMPRESA
			// MESMO(CONTRATANTE)
			ppv = new Pessoa_Perfil_e_Vinculo();
			if (Utilidades.getpPL().getPessoa_Logada() != null)
				ppv.setId_Pessoa_D(Utilidades.getpPL().getPessoa_Logada());
			else
				ppv.setId_Pessoa_D(null);
			ppv.setId_Pessoa_M(null);
			ppv.setEnum_Aux_Perfil_Pessoa(null);
			ppv1 = ppv;
			ppv1 = loginContratanteOuContratado();
			if (ppv1 == null) {
				Utilidades.getpPL().setVinculoproprio(true);
				Utilidades.enviaAlertError("LOGIN", "VINCULO",
						"Você não está vinculoado à: " + Utilidades.getpPL().getEmpresa_Logada().getFantasia_Apelido());
				return false;
			} else {
				Utilidades.getpPL().setPerfil_Logado(ppv1.getEnum_Aux_Perfil_Pessoa());
				Utilidades.getpPL().setVinculoproprio(false);
			}
		}
		
		return true;
	}

}
