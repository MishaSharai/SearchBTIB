package by.btib.SearchBTIB.repository;

import by.btib.SearchBTIB.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {}