package br.com.unip.aps.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.unip.aps.chat.dto.Userdto;
import br.com.unip.aps.modelo.User;
import br.com.unip.aps.repository.UserRepository;

@Service
public class Autenticacao {

	@Autowired
	private UserRepository repository;

	public boolean UsuarioExiste(Userdto userdto) {

		boolean retorno = false;

		try {
			User userRec = userdto.toUser();
			User user = repository.findByEmail(userRec.getEmail()).get();

			if (user != null) {
				System.out.println("Usuário: " + user.getNome() + " foi encotrado");
				retorno = true;
			}
		}

		catch (Exception e) {
			System.out.println("Usuário não foi encotrado");
			retorno = false;
		}
		System.out.println(retorno);
		return retorno;

	}

}
