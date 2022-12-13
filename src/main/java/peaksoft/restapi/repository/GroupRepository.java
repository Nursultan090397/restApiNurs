package peaksoft.restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import peaksoft.restapi.entities.Course;
import peaksoft.restapi.entities.Group;

import java.util.List;

@Repository
public interface GroupRepository extends JpaRepository<Group,Long> {



}
