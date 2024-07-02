package com.enviro.assessment.grad001.PreciousMotloung.waste_sorting_app.Service;

import com.enviro.assessment.grad001.PreciousMotloung.waste_sorting_app.repositories.RecyclingRepository;
import com.enviro.assessment.grad001.PreciousMotloung.waste_sorting_app.models.RecyclingTips;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Service class for managing {@link RecyclingTips}.
 */
@Service
public class RecyclingTipService {

    @Autowired
    private RecyclingRepository recyclingRepository;

    /**
     * Retrieves all recycling tips.
     *
     * @return a list of all recycling tips.
     */
    public List<RecyclingTips> findAll() {
        return recyclingRepository.findAll();
    }

    /**
     * Retrieves a recycling tip by its ID.
     *
     * @param id the ID of the recycling tip to retrieve.
     * @return an Optional containing the recycling tip, or empty if not found.
     */
    public Optional<RecyclingTips> findById(Long id) {
        return recyclingRepository.findById(id);
    }

    /**
     * Saves or updates a recycling tip.
     *
     * @param recyclingTips the recycling tip to save or update.
     * @return the saved recycling tip.
     */
    public RecyclingTips save(RecyclingTips recyclingTips) {
        return recyclingRepository.save(recyclingTips);
    }

    /**
     * Deletes a recycling tip by its ID.
     *
     * @param id the ID of the recycling tip to delete.
     */
    public void deleteById(Long id) {
        recyclingRepository.deleteById(id);
    }
}

