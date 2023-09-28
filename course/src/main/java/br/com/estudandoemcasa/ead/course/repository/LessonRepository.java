package br.com.estudandoemcasa.ead.course.repository;

import br.com.estudandoemcasa.ead.course.models.LessonModel;
import br.com.estudandoemcasa.ead.course.models.ModuleModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface LessonRepository extends JpaRepository<LessonModel, UUID> {
}
