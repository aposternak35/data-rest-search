package org.aposternak35.app.repository;

import org.aposternak35.app.domain.Mark;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface MarkRepository extends JpaRepository<Mark, Long> {
    Mark findByName(String name);
}
