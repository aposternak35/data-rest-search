package org.aposternak35.app.repository;


import org.aposternak35.app.domain.Model;
import org.aposternak35.app.domain.Modification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ModificationRepository extends JpaRepository<Modification, Long> {


}
