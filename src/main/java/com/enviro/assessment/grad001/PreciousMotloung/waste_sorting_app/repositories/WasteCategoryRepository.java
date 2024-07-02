package com.enviro.assessment.grad001.PreciousMotloung.waste_sorting_app.repositories;

import com.enviro.assessment.grad001.PreciousMotloung.waste_sorting_app.models.WasteCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for managing WasteCategory entities.
 */
@Repository
public interface WasteCategoryRepository extends JpaRepository<WasteCategory, Long> {
}
