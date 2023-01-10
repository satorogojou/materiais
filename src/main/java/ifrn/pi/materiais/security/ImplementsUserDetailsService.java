package ifrn.pi.materiais.security;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import ifrn.pi.materiais.models.Usuario;
import ifrn.pi.materiais.repository.UsuarioRepository;

@Repository
@Transactional
public class ImplementsUserDetailsService implements UserDetailsService{
	
	@Autowired
	UsuarioRepository ur;
	
	@Override
	public UserDetails loadUserByUsername(String matricula) throws UsernameNotFoundException {
		Usuario usuario = ur.findByMatricula(matricula);
		
		if(usuario == null) {
			throw new UsernameNotFoundException("Usuario não encontrado!");
		}	
		return new User(usuario.getUsername(), usuario.getPassword(), true, true, true, true, usuario.getAuthorities());
	}

}
