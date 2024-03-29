package k23BE.Harkkatyo.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="tila")
public class Tila {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long tilaid;
	@Column(name = "nimike", nullable = false, unique = true)
	private String nimike;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "tila")
	@JsonIgnore
	private List<Projekti> projektit;

	public Tila(String nimike) {
		super();
		this.nimike = nimike;
	}
	
	public Tila() {
		super();
	}

	public Long getTilaid() {
		return tilaid;
	}

	public void setTilaid(Long tilaid) {
		this.tilaid = tilaid;
	}

	public String getNimike() {
		return nimike;
	}

	public void setNimike(String nimike) {
		this.nimike = nimike;
	}

	public List<Projekti> getProjektit() {
		return projektit;
	}

	public void setProjektit(List<Projekti> projektit) {
		this.projektit = projektit;
	}

	@Override
	public String toString() {
		return "Tila [tilaid=" + tilaid + ", nimike=" + nimike + "]";
	}

	
	
	
}
