package org.aposternak35.app.service;

import org.aposternak35.app.domain.Mark;
import org.aposternak35.app.domain.Model;
import org.aposternak35.app.domain.Modification;
import org.aposternak35.app.repository.MarkRepository;
import org.aposternak35.app.repository.ModelRepository;
import org.aposternak35.app.repository.ModificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class SearchService {

    @Autowired
    MarkRepository markRepository;
    @Autowired
    ModelRepository modelRepository;
    @Autowired
    ModificationRepository modificationRepository;


    public Mark findByMarkAndModelAndPeriod(String mark,String model,int begin,int end){
        Mark findMark=markRepository.findByName(mark);
        List<Model> findModels=new ArrayList<>();
        List<Modification> findModifs=new ArrayList<>();
        for(Model bufModel:findMark.getModels()){
            if (bufModel.getName()==model){
                for(Modification bufModif:bufModel.getModifications()){
                    if(bufModif.getPeriodBegin()>=begin && bufModif.getPeriodEnd()<=end){
                        findModifs.add(bufModif);
                    }
                }
                bufModel.setModifications(findModifs);
                findModifs.clear();
                findModels.add(bufModel);
            }
        }

        findMark.setModels(findModels);

            return findMark;

    }

}
