package br.com.estudandoemcasa.ead.course.service.impl;

import br.com.estudandoemcasa.ead.course.repository.LessonRepository;
import br.com.estudandoemcasa.ead.course.service.LessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LessonServiceImpl implements LessonService {

    @Autowired
    private LessonRepository lessonRepository;

}
