package com.dev.url_shortner.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    User findUserByEmail(String email);

    boolean existsByEmail(String email);

    @SuppressWarnings({ "null", "unchecked" })
    User save(User user);

    void delete(@SuppressWarnings("null") User user);
}
