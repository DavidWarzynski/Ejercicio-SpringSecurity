package es.neesis.security.repository;

import es.neesis.security.model.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRoleRepository extends JpaRepository<RoleEntity,Long> {
}
