package com.eramosce.demos.boot.covid19service.repository;

import com.eramosce.demos.boot.covid19service.model.Covid19DataUpdate;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface Covid19DataUpdateRepository extends PagingAndSortingRepository<Covid19DataUpdate, String> {

}
