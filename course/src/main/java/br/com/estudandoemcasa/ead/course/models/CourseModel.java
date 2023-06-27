package br.com.estudandoemcasa.ead.course.models;

import br.com.estudandoemcasa.ead.course.enums.CourseLevel;
import br.com.estudandoemcasa.ead.course.enums.CourseStatus;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "TB_COURSES")
public class CourseModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID courseId;

    private String name;
    private String description;
    private String imageUrl;
    private LocalDateTime creationDate;
    private LocalDateTime lastUpdateDate;
    private CourseStatus courseStatus;
    private CourseLevel courseLevel;
    private UUID userInstructor;

    /**
     * TODO assistir video Mapear Entidades, criar Repositories e Services para Multiplas Entidades
     * minuto 09:48 - Mapear atributos da entidade CourseModel
     */

}
