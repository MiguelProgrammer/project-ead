package br.com.estudandoemcasa.ead.course.service.impl;

import br.com.estudandoemcasa.ead.course.repository.ModuleRepository;
import br.com.estudandoemcasa.ead.course.service.ModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ModuleServiceImpl implements ModuleService {

    @Autowired
    private ModuleRepository moduleRepository;
}
