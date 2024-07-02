package com.enviro.assessment.grad001.PreciousMotloung.waste_sorting_app.Service;

import com.enviro.assessment.grad001.PreciousMotloung.waste_sorting_app.repositories.WasteCategoryRepository;
import com.enviro.assessment.grad001.PreciousMotloung.waste_sorting_app.models.WasteCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Service class for managing {@link WasteCategory}.
 */
@Service
public class WasteCategoryService {

    @Autowired
    private WasteCategoryRepository wasteCategoryRepository;

    /**
     * Retrieves all waste categories.
     *
     * @return a list of all waste categories.
     */
    public List<WasteCategory> findAll() {
        return wasteCategoryRepository.findAll();
    }

    /**
     * Retrieves a waste category by its ID.
     *
     * @param id the ID of the waste category to retrieve.
     * @return an Optional containing the waste category, or empty if not found.
     */
    public Optional<WasteCategory> findById(Long id) {
        return wasteCategoryRepository.findById(id);
    }

    /**
     * Saves or updates a waste category.
     *
     * @param wasteCategory the waste category to save or update.
     * @return the saved waste category.
     */
    public WasteCategory save(WasteCategory wasteCategory) {
        return wasteCategoryRepository.save(wasteCategory);
    }

    /**
     * Deletes a waste category by its ID.
     *
     * @param id the ID of the waste category to delete.
     */
    public void deleteById(Long id) {
        wasteCategoryRepository.deleteById(id);
    }
}

