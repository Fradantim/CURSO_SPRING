package com.fradantim.sensorDeVelocidad.persistence.entites;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class AbsEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="ID")
	protected UUID id;

	public UUID getId() {
		return id;
	}

	@Override
	public boolean equals(Object other) {
		if (other == null) return false;
		if (other == this) return true;
	    if (!(other instanceof AbsEntity))return false;
	    AbsEntity otherMyClass = (AbsEntity)other;
		return this.id.equals(otherMyClass.getId());
	}
}
