package expirimenting.with.hibernate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import expirimenting.with.hibernate.entity.User;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
