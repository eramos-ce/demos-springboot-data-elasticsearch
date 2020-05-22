package com.eramosce.demos.boot.covid19service.service.implementation;

import com.eramosce.demos.boot.covid19service.model.Covid19DataUpdate;
import com.eramosce.demos.boot.covid19service.repository.Covid19DataUpdateRepository;
import com.eramosce.demos.boot.covid19service.service.Covid19UpdatesService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Covid19UpdatesServiceImpl implements Covid19UpdatesService {

  @Autowired
  Covid19DataUpdateRepository updateRepository;

  @Override
  public Covid19DataUpdate add(Covid19DataUpdate dataUpdate) {
    return updateRepository.save(dataUpdate);
  }

  @Override
  public Covid19DataUpdate delete(Covid19DataUpdate dataUpdate) {
    updateRepository.delete(dataUpdate);
    return dataUpdate;
  }

  @Override
  public List<Covid19DataUpdate> getAll() {
    List<Covid19DataUpdate> outputList = new ArrayList<>();
    Iterable<Covid19DataUpdate> allUpdates = updateRepository.findAll();
    allUpdates.forEach( c -> outputList.add(c));
    return outputList;
  }
}
