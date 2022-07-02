package org.aposternak35.app.service;

import org.aposternak35.app.domain.Mark;
import org.aposternak35.app.repository.MarkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MarkService{
    @Autowired
    MarkRepository markRepository;

    public List getAll(){
        return new ArrayList<>(markRepository.findAll());
    }

    public Mark getById(long uid){
        return markRepository.findById(uid).get();
    }

    public void saveOrUpdate(Mark mark){
        markRepository.save(mark);
    }

    public void delete(long uid){
        markRepository.deleteById(uid);
    }

}
