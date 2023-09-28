package br.com.estudandoemcasa.ead.course.repository;

import br.com.estudandoemcasa.ead.course.models.CourseModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CourseRepository extends JpaRepository<CourseModel, UUID> {
}
