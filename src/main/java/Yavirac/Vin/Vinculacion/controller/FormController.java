package Yavirac.Vin.Vinculacion.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Yavirac.Vin.Vinculacion.entity.FormEntity;
import Yavirac.Vin.Vinculacion.service.FormService;

@RestController
@RequestMapping("/forms")
public class FormController {

    @Autowired
    private FormService formService;

    @PostMapping("/submit")
    public ResponseEntity<FormEntity> submitForm(@RequestBody FormEntity formEntity) {
        FormEntity savedForm = formService.saveForm(formEntity);
        return new ResponseEntity<>(savedForm, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<FormEntity>> getAllForms() {
        List<FormEntity> forms = formService.getAllForms();
        return new ResponseEntity<>(forms, HttpStatus.OK);
    }
}

