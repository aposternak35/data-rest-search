package org.aposternak35.app.service;

import org.aposternak35.app.domain.Modification;
import org.aposternak35.app.repository.ModificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ModificationService {
    @Autowired
    ModificationRepository modificationRepository;

    public List getAll(){
        return new ArrayList<>(modificationRepository.findAll());
    }

    public Modification getById(long uid){
        return modificationRepository.findById(uid).get();
    }

    public void saveOrUpdate(Modification modification){
        modificationRepository.save(modification);
    }

    public void delete(long uid){
        modificationRepository.deleteById(uid);
    }
}
