package ifrn.pi.materiais.repository;

import org.springframework.data.repository.CrudRepository;

import ifrn.pi.materiais.models.Material;

public interface MaterialRepository extends CrudRepository<Material, String> {

	Material findByCodigo(long codigo);
}
