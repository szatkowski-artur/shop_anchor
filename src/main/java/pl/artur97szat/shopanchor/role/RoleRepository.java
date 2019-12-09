package pl.artur97szat.shopanchor.role;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, String> {

    Role getByName(String name);

}
