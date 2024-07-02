package com.enviro.assessment.grad001.PreciousMotloung.waste_sorting_app.controllers;

import com.enviro.assessment.grad001.PreciousMotloung.waste_sorting_app.Service.DisposalGuidelineService;
import com.enviro.assessment.grad001.PreciousMotloung.waste_sorting_app.exception.ResourceNotFoundException;
import com.enviro.assessment.grad001.PreciousMotloung.waste_sorting_app.models.DisposalGuidelines;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller for managing disposal guidelines.
 */
@RestController
@RequestMapping("/api/disposal-guidelines")
public class DisposalGuidelineController {

    @Autowired
    private DisposalGuidelineService disposalGuidelineService;

    /**
     * Retrieve all disposal guidelines.
     *
     * @return a list of all disposal guidelines.
     */
    @GetMapping
    public List<DisposalGuidelines> getAllDisposalGuidelines() {
        return disposalGuidelineService.findAll();
    }

    /**
     * Retrieve a specific disposal guideline by its ID.
     *
     * @param id the ID of the disposal guideline to retrieve.
     * @return the disposal guideline if found, otherwise throws ResourceNotFoundException.
     */
    @GetMapping("/{id}")
    public ResponseEntity<DisposalGuidelines> getGuidelineById(@PathVariable Long id) {
        DisposalGuidelines disposalGuidelines = disposalGuidelineService.findById(id).orElse(null);

        if (disposalGuidelines == null) {
            throw new ResourceNotFoundException("Disposal guideline not found with id " + id);
        }

        return ResponseEntity.ok(disposalGuidelines);
    }

    /**
     * Create a new disposal guideline.
     *
     * @param disposalGuidelines the disposal guideline to create.
     * @return the created disposal guideline.
     */
    @PostMapping
    public ResponseEntity<DisposalGuidelines> createDisposalGuideline(@Valid @RequestBody DisposalGuidelines
                                                                                  disposalGuidelines) {
        return ResponseEntity.ok(disposalGuidelineService.save(disposalGuidelines));
    }

    /**
     * Update an existing disposal guideline.
     *
     * @param id the ID of the disposal guideline to update.
     * @param disposalGuidelines the updated disposal guideline details.
     * @return the updated disposal guideline.
     */
    @PutMapping("/{id}")
    public ResponseEntity<DisposalGuidelines> updateDisposalGuideline(@PathVariable Long id, @Valid @RequestBody
    DisposalGuidelines disposalGuidelines) {
        DisposalGuidelines existingGuideline = disposalGuidelineService.findById(id).orElse(null);

        if (existingGuideline == null) {
            throw new ResourceNotFoundException("Disposal guideline not found with id " + id);
        }

        existingGuideline.setCategory(disposalGuidelines.getCategory());
        existingGuideline.setDisposalGuideline(disposalGuidelines.getDisposalGuideline());
        return ResponseEntity.ok(disposalGuidelineService.save(existingGuideline));
    }

    /**
     * Delete a specific disposal guideline by its ID.
     *
     * @param id the ID of the disposal guideline to delete.
     * @return a ResponseEntity indicating the outcome.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteDisposalGuideline(@PathVariable Long id) {
        DisposalGuidelines disposalGuidelines = disposalGuidelineService.findById(id).orElse(null);

        if (disposalGuidelines == null) {
            throw new ResourceNotFoundException("Disposal guideline not found with id " + id);
        }

        disposalGuidelineService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
