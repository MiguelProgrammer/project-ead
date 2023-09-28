package br.com.estudandoemcasa.ead.course.service.impl;

import br.com.estudandoemcasa.ead.course.repository.CourseRepository;
import br.com.estudandoemcasa.ead.course.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepository;
}
