package com.cv.repositories;

import com.cv.entities.User;
import com.cv.entities.UsersCars;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsersCarsRepository extends JpaRepository<UsersCars, Long> {
    List<UsersCars> findByUser(User user);
}
