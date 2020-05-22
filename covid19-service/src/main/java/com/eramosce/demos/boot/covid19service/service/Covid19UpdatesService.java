package com.eramosce.demos.boot.covid19service.service;

import com.eramosce.demos.boot.covid19service.model.Covid19DataUpdate;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface Covid19UpdatesService {

  /**
   * Adds a new Covid19 data point.  Callers should use returned instance as the object might have returned
   * a new type completely.
   * @param dataUpdate data to be added
   * @return new instance as returned by the underlying repository.
   */
  Covid19DataUpdate add(Covid19DataUpdate dataUpdate);

  /**
   * Delete the provided data point
   * @param dataUpdate data point to delete
   * @return reference to the deleted data point
   */
  Covid19DataUpdate delete(Covid19DataUpdate dataUpdate);

  /**
   * Retrieves all data updates available.
   * @return a list containing all the data updates
   */
  List<Covid19DataUpdate> getAll();

}
