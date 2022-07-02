package org.aposternak35.app.controller;

import org.aposternak35.app.domain.Mark;
import org.aposternak35.app.domain.Model;
import org.aposternak35.app.domain.Modification;
import org.aposternak35.app.service.MarkService;
import org.aposternak35.app.service.ModelService;
import org.aposternak35.app.service.ModificationService;
import org.aposternak35.app.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

@RestController
public class MarkController {

    @Autowired
    MarkService markService;
    @Autowired
    ModelService modelService;
    @Autowired
    ModificationService modificationService;

    @Autowired
    SearchService searchService;

    @GetMapping("/mark")
    public List<Mark> getAllMarks(){
        return markService.getAll();
    }
    @GetMapping("/mark/{uid}")
    public Mark getMarkById(@PathVariable long uid){
        if(markService.getById(uid)!=null){
            return markService.getById(uid);
        }
        throw new NoSuchElementException();
    }

    @GetMapping("/mark/{uid}/model")
    public List<Model> getAllModels(@PathVariable long uid){
        if(markService.getById(uid)!=null){
            return markService.getById(uid).getModels();
        }
        return new ArrayList<>();
    }

    @GetMapping("/mark/{markId}/model/{modelId}")
    public Model getModelById(@PathVariable long markId,@PathVariable long modelId){
        for (Model model:markService.getById(markId).getModels()){
            if(model.getUid()==modelId){
                return model;
            }
        }
        throw new NoSuchElementException();
    }

    @GetMapping("/mark/{markId}/model/{modelId}/modification")
    public List<Modification> getAllModifications(@PathVariable long markId, @PathVariable long modelId){
        for(Model model:markService.getById(markId).getModels()){
            if(model.getUid()==modelId){
                return model.getModifications();
            }
        }
        throw new NoSuchElementException();
    }

    @GetMapping("/mark/{markId}/model/{modelId}/modification/{modificationId}")
    public Modification getModificationById(@PathVariable long markId,@PathVariable long modelId, @PathVariable long modificationId){
        for (Model model:markService.getById(markId).getModels()){
            if(model.getUid()==modelId){
                for (Modification modification:model.getModifications()){
                    if(modification.getUid()==modificationId){
                        return modification;
                    }
                }
            }
        }
        throw new NoSuchElementException();
    }

    @PostMapping("/mark")
    public Mark saveMark(@RequestBody Mark mark){
        markService.saveOrUpdate(mark);
        return mark;
    }

    @PostMapping("/mark/{uid}/model")
    public Model saveModel(@PathVariable long uid,@RequestBody Model model){
        markService.getById(uid).getModels().add(model);
        model.setMark(markService.getById(uid));
        modelService.saveOrUpdate(model);
        return model;
    }

    @PostMapping("/mark/{markId}/model/{modelId}/modification")
    public Modification saveModification(@PathVariable long markId, @PathVariable long modelId, @RequestBody Modification modification){
        modelService.getById(modelId).getModifications().add(modification);
        modification.setModel(modelService.getById(modelId));
        modificationService.saveOrUpdate(modification);
        return modification;
    }

    @GetMapping("/search")
    public Mark findByMarkAndModelAndPeriod(@RequestParam String mark, String model, int periodBegin, int periodEnd){

     return searchService.findByMarkAndModelAndPeriod(mark,model,periodBegin,periodEnd);
    }
}
