package com.enviro.assessment.grad001.PreciousMotloung.waste_sorting_app.Service;

import com.enviro.assessment.grad001.PreciousMotloung.waste_sorting_app.repositories.DisposalGuidelineRepository;
import com.enviro.assessment.grad001.PreciousMotloung.waste_sorting_app.models.DisposalGuidelines;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Service class for managing {@link DisposalGuidelines}.
 */
@Service
public class DisposalGuidelineService {

    @Autowired
    private DisposalGuidelineRepository disposalGuidelineRepository;

    /**
     * Retrieves all disposal guidelines.
     *
     * @return a list of all disposal guidelines.
     */
    public List<DisposalGuidelines> findAll() {
        return disposalGuidelineRepository.findAll();
    }

    /**
     * Retrieves a disposal guideline by its ID.
     *
     * @param id the ID of the disposal guideline to retrieve.
     * @return an Optional containing the disposal guideline, or empty if not found.
     */
    public Optional<DisposalGuidelines> findById(Long id) {
        return disposalGuidelineRepository.findById(id);
    }

    /**
     * Saves or updates a disposal guideline.
     *
     * @param disposalGuidelines the disposal guideline to save or update.
     * @return the saved disposal guideline.
     */
    public DisposalGuidelines save(DisposalGuidelines disposalGuidelines) {
        return disposalGuidelineRepository.save(disposalGuidelines);
    }

    /**
     * Deletes a disposal guideline by its ID.
     *
     * @param id the ID of the disposal guideline to delete.
     */
    public void deleteById(Long id) {
        disposalGuidelineRepository.deleteById(id);
    }
}
