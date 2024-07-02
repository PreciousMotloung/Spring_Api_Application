package com.enviro.assessment.grad001.PreciousMotloung.waste_sorting_app.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

/**
 * Entity representing disposal guidelines.
 */
@Entity
public class DisposalGuidelines {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Category is mandatory")
    @Size(min = 5, max = 50, message = "Category must be between 5 and 50 characters")
    private String category;

    @NotBlank(message = "Disposal guideline is mandatory")
    @Size(min = 5, max = 200, message = "Disposal guideline must be between 5 and 200 characters")
    private String disposalGuideline;

    /**
     * Default constructor for JPA.
     */
    public DisposalGuidelines() {}

    /**
     * Constructs a new DisposalGuidelines with the specified category and disposal guideline.
     *
     * @param category the category of the disposal guideline.
     * @param disposalGuideline the disposal guideline details.
     */
    public DisposalGuidelines(String category, String disposalGuideline) {
        this.category = category;
        this.disposalGuideline = disposalGuideline;
    }

    /**
     * Gets the ID of the disposal guideline.
     *
     * @return the ID of the disposal guideline.
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the ID of the disposal guideline.
     *
     * @param id the new ID of the disposal guideline.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets the category of the disposal guideline.
     *
     * @return the category of the disposal guideline.
     */
    public String getCategory() {
        return category;
    }

    /**
     * Sets the category of the disposal guideline.
     *
     * @param category the new category of the disposal guideline.
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * Gets the disposal guideline details.
     *
     * @return the disposal guideline details.
     */
    public String getDisposalGuideline() {
        return disposalGuideline;
    }

    /**
     * Sets the disposal guideline details.
     *
     * @param disposalGuideline the new disposal guideline details.
     */
    public void setDisposalGuideline(String disposalGuideline) {
        this.disposalGuideline = disposalGuideline;
    }
}
