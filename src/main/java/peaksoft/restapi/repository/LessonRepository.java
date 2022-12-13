package peaksoft.restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import peaksoft.restapi.entities.Lesson;

import java.util.List;

@Repository
public interface LessonRepository extends JpaRepository<Lesson,Long> {
    @Query(value = "select l from Lesson l where l.course.id = :courseId")
    List<Lesson> findAllLessonByCourseId(Long courseId);
}
