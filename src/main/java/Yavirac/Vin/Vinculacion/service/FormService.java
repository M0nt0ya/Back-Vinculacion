package Yavirac.Vin.Vinculacion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import Yavirac.Vin.Vinculacion.entity.FormEntity;
import Yavirac.Vin.Vinculacion.repository.FormRepository;


@Service
public class FormService {
    
    @Autowired
    private FormRepository formRepository;

    @Transactional
    public FormEntity saveForm(FormEntity formEntity) {
        return formRepository.save(formEntity);
    }
    
    @Transactional(readOnly = true)
    public List<FormEntity> getAllForms() {
        return formRepository.findAll();
    }
}
