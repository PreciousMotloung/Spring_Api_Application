package com.enviro.assessment.grad001.PreciousMotloung.waste_sorting_app.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

/**
 * Entity representing a waste category.
 */
@Entity
public class WasteCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name is mandatory")
    @Size(min = 5, max = 50, message = "Name must be between 5 and 50 characters")
    private String name;

    @NotBlank(message = "Description is mandatory")
    @Size(min = 5, max = 200, message = "Description must be between 5 and 200 characters")
    private String description;

    /**
     * Default constructor for JPA.
     */
    public WasteCategory() {}

    /**
     * Constructs a new WasteCategory with the specified name and description.
     *
     * @param name the name of the waste category.
     * @param description the description of the waste category.
     */
    public WasteCategory(String name, String description) {
        this.name = name;
        this.description = description;
    }

    /**
     * Gets the ID of the waste category.
     *
     * @return the ID of the waste category.
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the ID of the waste category.
     *
     * @param id the new ID of the waste category.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets the name of the waste category.
     *
     * @return the name of the waste category.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the waste category.
     *
     * @param name the new name of the waste category.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the description of the waste category.
     *
     * @return the description of the waste category.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the description of the waste category.
     *
     * @param description the new description of the waste category.
     */
    public void setDescription(String description) {
        this.description = description;
    }
}
