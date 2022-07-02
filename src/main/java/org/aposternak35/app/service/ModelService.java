package org.aposternak35.app.service;

import org.aposternak35.app.domain.Model;
import org.aposternak35.app.repository.ModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ModelService {
    @Autowired
    ModelRepository modelRepository;

    public List getAll(){
        return new ArrayList<>(modelRepository.findAll());
    }

    public Model getById(long uid){
        return modelRepository.findById(uid).get();
    }

    public void saveOrUpdate(Model model){
        modelRepository.save(model);
    }

    public void delete(long uid){
        modelRepository.deleteById(uid);
    }
}
