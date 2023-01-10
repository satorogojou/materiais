package ifrn.pi.materiais.repository;

import org.springframework.data.repository.CrudRepository;

import ifrn.pi.materiais.models.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, String>{
		
	Usuario findByMatricula(String matricula);
	
	Iterable<Usuario> findAllByNomeContaining(String nome);
}
