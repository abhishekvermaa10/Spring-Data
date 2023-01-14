package com.scaleupindia.entity;

import java.time.LocalDate;

import com.scaleupindia.enums.Gender;
import com.scaleupindia.enums.PetType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * @author abhishekvermaa10
 *
 */
@Entity
@Table(name = "pet_table")
public class Pet {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private int id;
	@Column(name = "name", nullable = false, length = 255)
	private String name;
	@Column(name = "date_of_birth", nullable = false)
	private LocalDate birthDate;
	@Enumerated(value = EnumType.STRING)
	@Column(name = "gender", nullable = false)
	private Gender gender;
	@Enumerated(value = EnumType.STRING)
	@Column(name = "type", nullable = false)
	private PetType type;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public PetType getType() {
		return type;
	}

	public void setType(PetType type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Pet [id=" + id + ", name=" + name + ", birthDate=" + birthDate + ", gender=" + gender + ", type=" + type
				+ "]";
	}
}
