package k23BE.Harkkatyo.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

// import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Auto {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long rekno;
	private String merkki;
	private String malli;
	private String vuosi;
	private String tiedot;
	private double hinta;
	private String kuva; // hox

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "auto")
	private List<Projekti> projektit;

	// pelkkä auto constructor
	public Auto(String merkki, String malli, String vuosi, String tiedot, double hinta, String kuva) {
		super();
		this.merkki = merkki;
		this.malli = malli;
		this.vuosi = vuosi;
		this.tiedot = tiedot;
		this.hinta = hinta;
		this.kuva = kuva;
	}

	public Auto() {
		super();
	}

	public Long getRekno() {
		return rekno;
	}

	public void setRekno(Long rekno) {
		this.rekno = rekno;
	}

	public String getMerkki() {
		return merkki;
	}

	public void setMerkki(String merkki) {
		this.merkki = merkki;
	}

	public String getMalli() {
		return malli;
	}

	public void setMalli(String malli) {
		this.malli = malli;
	}

	public String getVuosi() {
		return vuosi;
	}

	public void setVuosi(String vuosi) {
		this.vuosi = vuosi;
	}

	public String getTiedot() {
		return tiedot;
	}

	public void setTiedot(String tiedot) {
		this.tiedot = tiedot;
	}

	public double getHinta() {
		return hinta;
	}

	public void setHinta(double hinta) {
		this.hinta = hinta;
	}

	public String getKuva() {
		return kuva;
	}

	public void setKuva(String kuva) {
		this.kuva = kuva;
	}

	public List<Projekti> getProjektit() {
		return projektit;
	}

	public void setProjektit(List<Projekti> projektit) {
		this.projektit = projektit;
	}

	@Override
	public String toString() {
		return "Auto [rekno=" + rekno + ", merkki=" + merkki + ", malli=" + malli + ", vuosi=" + vuosi + ", tiedot="
				+ tiedot + ", hinta=" + hinta + ", kuva=" + kuva + "]";
	}
	
	
}
