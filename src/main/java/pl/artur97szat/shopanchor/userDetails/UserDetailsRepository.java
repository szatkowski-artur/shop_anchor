package pl.artur97szat.shopanchor.userDetails;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDetailsRepository extends JpaRepository<UserDetails, String> {

    UserDetails getByOwnerId(Long id);

}
