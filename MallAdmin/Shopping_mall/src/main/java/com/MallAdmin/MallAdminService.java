package com.MallAdmin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class MallAdminService {

    @Autowired
    private MallAdminRepository repo;

    // Fetches all MallAdmin records
    public List<MallAdmin> listAll() {
        return repo.findAll();
    }

    // Saves a new or updated MallAdmin entity
    public MallAdmin save(MallAdmin mallAdmin) {
        if (mallAdmin.getLastLoginTime() == null) {
            mallAdmin.setLastLoginTime(LocalDateTime.now());
        }
        return repo.save(mallAdmin);
    }

    // Fetches a MallAdmin by ID
    public MallAdmin get(Integer id) {
        return repo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "MallAdmin not found with ID: " + id));
    }

    // Deletes a MallAdmin by ID
    public void delete(Integer id) {
        if (!repo.existsById(id)) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "MallAdmin not found with ID: " + id);
        }
        repo.deleteById(id);
    }
}