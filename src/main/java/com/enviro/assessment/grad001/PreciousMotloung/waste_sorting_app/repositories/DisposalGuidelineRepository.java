package com.enviro.assessment.grad001.PreciousMotloung.waste_sorting_app.repositories;

import com.enviro.assessment.grad001.PreciousMotloung.waste_sorting_app.models.DisposalGuidelines;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for {@link DisposalGuidelines} entities.
 */
@Repository
public interface DisposalGuidelineRepository extends JpaRepository<DisposalGuidelines, Long> {
}
