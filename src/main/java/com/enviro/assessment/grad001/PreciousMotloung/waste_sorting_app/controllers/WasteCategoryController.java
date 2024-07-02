package com.enviro.assessment.grad001.PreciousMotloung.waste_sorting_app.controllers;

import com.enviro.assessment.grad001.PreciousMotloung.waste_sorting_app.exception.ResourceNotFoundException;
import com.enviro.assessment.grad001.PreciousMotloung.waste_sorting_app.Service.WasteCategoryService;
import com.enviro.assessment.grad001.PreciousMotloung.waste_sorting_app.models.WasteCategory;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller for managing waste categories.
 */
@RestController
@RequestMapping("/api/waste-categories")
public class WasteCategoryController {

    @Autowired
    private WasteCategoryService wasteCategoryService;

    /**
     * Retrieve all waste categories.
     *
     * @return a list of all waste categories.
     */
    @GetMapping
    public List<WasteCategory> getAllWasteCategories() {
        return wasteCategoryService.findAll();
    }

    /**
     * Retrieve a specific waste category by its ID.
     *
     * @param id the ID of the waste category to retrieve.
     * @return the waste category if found, otherwise throws ResourceNotFoundException.
     */
    @GetMapping("/{id}")
    public ResponseEntity<WasteCategory> getWasteCategoryById(@PathVariable Long id) {
        WasteCategory wasteCategory = wasteCategoryService.findById(id).orElse(null);

        if (wasteCategory == null) {
            throw new ResourceNotFoundException("Waste category not found with id " + id);
        }
        return ResponseEntity.ok(wasteCategory);
    }

    /**
     * Create a new waste category.
     *
     * @param wasteCategory the waste category to create.
     * @return the created waste category.
     */
    @PostMapping
    public ResponseEntity<WasteCategory> createWasteCategory(@Valid @RequestBody WasteCategory wasteCategory) {
        return ResponseEntity.ok(wasteCategoryService.save(wasteCategory));
    }

    /**
     * Update an existing waste category.
     *
     * @param id the ID of the waste category to update.
     * @param wasteCategory the updated waste category details.
     * @return the updated waste category.
     */
    @PutMapping("/{id}")
    public ResponseEntity<WasteCategory> updateWasteCategory(@PathVariable Long id, @Valid @RequestBody WasteCategory
            wasteCategory) {
        WasteCategory existingWasteCategory = wasteCategoryService.findById(id).orElse(null);
        if (existingWasteCategory == null) {
            throw new ResourceNotFoundException("Waste Category not found with id " + id);
        }

        existingWasteCategory.setName(wasteCategory.getName());
        existingWasteCategory.setDescription(wasteCategory.getDescription());
        return ResponseEntity.ok(wasteCategoryService.save(existingWasteCategory));
    }

    /**
     * Delete a specific waste category by its ID.
     *
     * @param id the ID of the waste category to delete.
     * @return a ResponseEntity indicating the outcome.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteWasteCategory(@PathVariable Long id) {
        WasteCategory wasteCategory = wasteCategoryService.findById(id).orElse(null);

        if (wasteCategory == null) {
            throw new ResourceNotFoundException("Waste Category not found with id " + id);
        }

        wasteCategoryService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
