package com.MallAdmin;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200") // Angular
@RequestMapping("mall_admin")
public class MallAdminController {

    @Autowired
    private MallAdminService service;

    // Get All Admins
    @GetMapping
    public List<MallAdmin> listAll() {
        return service.listAll();
    }

    // Get Admin by ID
    @GetMapping("/{id}")
    public MallAdmin get(@PathVariable Integer id) {
        return service.get(id); // If not found → returns 404 automatically
    }

    // Create new Admin
    @PostMapping
    public ResponseEntity<MallAdmin> add(@RequestBody MallAdmin mallAdmin) {
        MallAdmin saved = service.save(mallAdmin);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    // Update Admin
    @PutMapping("/{id}")
    public ResponseEntity<MallAdmin> update(@RequestBody MallAdmin mallAdmin, @PathVariable Integer id) {
        MallAdmin existing = service.get(id);

        existing.setUsername(mallAdmin.getUsername());
        existing.setPassword(mallAdmin.getPassword());
        existing.setEmail(mallAdmin.getEmail());
        existing.setLoginAttempts(mallAdmin.getLoginAttempts());
        existing.setIsActive(mallAdmin.getIsActive());
        existing.setLastLoginTime(mallAdmin.getLastLoginTime());

        service.save(existing);
        return ResponseEntity.ok(existing);
    }

    // Delete Admin
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build(); // 204 No Content
    }
}