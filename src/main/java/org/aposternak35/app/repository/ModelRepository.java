package org.aposternak35.app.repository;

import org.aposternak35.app.domain.Mark;
import org.aposternak35.app.domain.Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;
@Repository
public interface ModelRepository extends JpaRepository<Model, Long> {



}
