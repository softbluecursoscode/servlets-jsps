package livraria.action;

import webf.action.Action;

/**
 * Faz o logout de um usuário logado
 */
public class LogoutAction extends Action {

	@Override
	public void process() throws Exception {
		// Remove os atributos da sessão
		getSession().setAttribute("usuario", null);
		getSession().setAttribute("carrinho", null);
		
		redirect("usuario_deslogado.jsp");
	}
}
