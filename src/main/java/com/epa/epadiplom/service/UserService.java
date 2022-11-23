package com.epa.epadiplom.service;

import com.epa.epadiplom.entities.JobTitle;

import java.util.List;

public interface UserService {
    List<JobTitle> findAll();
    JobTitle findById(long id);
    void update(JobTitle jobTitle);
    void create(JobTitle jobTitle);
    void delete(long id);
}
