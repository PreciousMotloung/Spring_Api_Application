package com.enviro.assessment.grad001.PreciousMotloung.waste_sorting_app.controllers;

import com.enviro.assessment.grad001.PreciousMotloung.waste_sorting_app.Service.RecyclingTipService;
import com.enviro.assessment.grad001.PreciousMotloung.waste_sorting_app.exception.ResourceNotFoundException;
import com.enviro.assessment.grad001.PreciousMotloung.waste_sorting_app.models.RecyclingTips;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller for managing recycling tips.
 */
@RestController
@RequestMapping("/api/recycling-tips")
public class RecyclingTipsController {

    @Autowired
    private RecyclingTipService recyclingTipService;

    /**
     * Retrieve all recycling tips.
     *
     * @return a list of all recycling tips.
     */
    @GetMapping
    public List<RecyclingTips> getRecycling() {
        return recyclingTipService.findAll();
    }

    /**
     * Retrieve a specific recycling tip by its ID.
     *
     * @param id the ID of the recycling tip to retrieve.
     * @return the recycling tip if found, otherwise throws ResourceNotFoundException.
     */
    @GetMapping("/{id}")
    public ResponseEntity<RecyclingTips> getRecyclingTipById(@PathVariable Long id) {
        RecyclingTips recyclingTips = recyclingTipService.findById(id).orElse(null);

        if (recyclingTips == null) {
            throw new ResourceNotFoundException("Recycling tip not found with id " + id);
        }

        return ResponseEntity.ok(recyclingTips);
    }

    /**
     * Create a new recycling tip.
     *
     * @param recyclingTips the recycling tip to create.
     * @return the created recycling tip.
     */
    @PostMapping
    public ResponseEntity<RecyclingTips> createRecyclingTip(@Valid @RequestBody RecyclingTips recyclingTips) {
        return ResponseEntity.ok(recyclingTipService.save(recyclingTips));
    }

    /**
     * Update an existing recycling tip.
     *
     * @param id the ID of the recycling tip to update.
     * @param recyclingTips the updated recycling tip details.
     * @return the updated recycling tip.
     */
    @PutMapping("/{id}")
    public ResponseEntity<RecyclingTips> updateRecyclingTip(@PathVariable Long id, @Valid @RequestBody RecyclingTips
            recyclingTips) {
        RecyclingTips existingTip = recyclingTipService.findById(id).orElse(null);

        if (existingTip == null) {
            throw new ResourceNotFoundException("Recycling tip not found with id " + id);
        }

        existingTip.setTip(recyclingTips.getTip());
        return ResponseEntity.ok(recyclingTipService.save(existingTip));
    }

    /**
     * Delete a specific recycling tip by its ID.
     *
     * @param id the ID of the recycling tip to delete.
     * @return a ResponseEntity indicating the outcome.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteRecyclingTip(@PathVariable Long id) {
        RecyclingTips recyclingTips = recyclingTipService.findById(id).orElse(null);

        if (recyclingTips == null) {
            throw new ResourceNotFoundException("Recycling tip not found with id " + id);
        }

        recyclingTipService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
