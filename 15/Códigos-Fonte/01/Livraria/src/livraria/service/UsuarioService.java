package livraria.service;

import livraria.dao.UsuarioDAO;
import livraria.entity.Usuario;
import webf.dao.DAOException;
import webf.service.Service;
import webf.service.ServiceException;

public class UsuarioService extends Service {

	/**
	 * Salva um usu�rio n�o existente
	 * @param usuario
	 * @return
	 * @throws ServiceException
	 */
	public boolean salvar(Usuario usuario) throws ServiceException {
		try {
			UsuarioDAO usuarioDAO = daoFactory.getDAO(UsuarioDAO.class);

			// Se um usu�rio com o mesmo e-mail j� existir, n�o insere e retorna false
			boolean jaExiste = usuarioDAO.existeUsuario(usuario.getEmail());

			if (jaExiste) {
				return false;
			}

			usuarioDAO.save(usuario);
			return true;
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
	}

	/**
	 * Efetua o login de um usu�rio
	 * @param email
	 * @param senha
	 * @return
	 * @throws ServiceException
	 */
	public Usuario login(String email, String senha) throws ServiceException {
		try {
			UsuarioDAO usuarioDAO = daoFactory.getDAO(UsuarioDAO.class);
			
			// Obt�m o usu�rio pelo seu e-mail
			Usuario usuario = usuarioDAO.getUsuarioByEmail(email);
			
			if (usuario == null) {
				// Usu�rio n�o existe
				return null;
			}
			
			if (!usuario.getSenha().equals(senha)) {
				// Senha digitada difere da senha cadastrada
				return null;
			}
			
			return usuario;

		} catch (DAOException e) {
			throw new ServiceException(e);
		}
	}
}
