package com.enviro.assessment.grad001.PreciousMotloung.waste_sorting_app.repositories;

import com.enviro.assessment.grad001.PreciousMotloung.waste_sorting_app.models.RecyclingTips;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for managing RecyclingTips entities.
 */
@Repository
public interface RecyclingRepository extends JpaRepository<RecyclingTips, Long> {
}
