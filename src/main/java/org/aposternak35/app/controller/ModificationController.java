package org.aposternak35.app.controller;

import org.aposternak35.app.domain.Model;
import org.aposternak35.app.domain.Modification;
import org.aposternak35.app.service.ModelService;
import org.aposternak35.app.service.ModificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
public class ModificationController {
    @Autowired
    ModificationService modificationService;

    @GetMapping("/modification")
    public List<Modification> getAllModifications(){
        return modificationService.getAll();
    }
    @GetMapping("/modification/{uid}")
    public Modification getModificationById(@PathVariable long uid){
        return modificationService.getById(uid);
    }

    @PostMapping("/modification")
    public Modification saveModification(@RequestBody Modification modification){
        modificationService.saveOrUpdate(modification);
        return modification;
    }

}
