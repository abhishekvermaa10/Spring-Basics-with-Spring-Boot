package com.abhishekvermaa10.dto;

import java.util.Objects;

/**
 * @author abhishekvermaa10
 *
 */
public class WildPetDTO extends PetDTO {
	
	private String birthPlace;

	public String getBirthPlace() {
		return birthPlace;
	}

	public void setBirthPlace(String birthPlace) {
		this.birthPlace = birthPlace;
	}

	@Override
	public String toString() {
		if (Objects.nonNull(getOwnerDTO())) {
			return "WildPetDTO [id=" + getId() + ", name=" + getName() + ", gender=" + getGender() + ", type="
					+ getType() + ", birthPlace=" + birthPlace + ", ownerDTO=" + getOwnerDTO() + "]";
		} else {
			return "WildPetDTO [id=" + getId() + ", name=" + getName() + ", gender=" + getGender() + ", type="
					+ getType() + ", birthPlace=" + birthPlace + "]";
		}
	}
	
}
