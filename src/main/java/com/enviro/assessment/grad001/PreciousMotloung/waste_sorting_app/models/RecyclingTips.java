package com.enviro.assessment.grad001.PreciousMotloung.waste_sorting_app.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

/**
 * Entity representing recycling tips.
 */
@Entity
public class RecyclingTips {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Tip is mandatory")
    @Size(min = 5, max = 200, message = "Recycling tip must be between 5 and 200 characters")
    private String tip;

    /**
     * Default constructor for JPA.
     */
    public RecyclingTips() {}

    /**
     * Constructs a new RecyclingTips with the specified tip.
     *
     * @param tip the recycling tip.
     */
    public RecyclingTips(String tip) {
        this.tip = tip;
    }

    /**
     * Gets the ID of the recycling tip.
     *
     * @return the ID of the recycling tip.
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the ID of the recycling tip.
     *
     * @param id the new ID of the recycling tip.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets the recycling tip.
     *
     * @return the recycling tip.
     */
    public String getTip() {
        return tip;
    }

    /**
     * Sets the recycling tip.
     *
     * @param tip the new recycling tip.
     */
    public void setTip(String tip) {
        this.tip = tip;
    }
}
