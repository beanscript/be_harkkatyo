package k23BE.Harkkatyo.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Auto {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long autoid;
	@Column(name = "merkki", nullable = false)
	private String merkki;
	@Column(name = "malli", nullable = false, unique = true)
	private String malli;
	private int vuosi;
	private String rekno;
	private String tiedot;
	private double hinta;
	private String kuva;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "auto")
	@JsonIgnore
	private List<Projekti> projektit;

	// pelkkä auto constructor
	public Auto(String merkki, String malli, int vuosi, String rekno, String tiedot, double hinta, String kuva) {
		super();
		this.merkki = merkki;
		this.malli = malli;
		this.vuosi = vuosi;
		this.rekno = rekno;
		this.tiedot = tiedot;
		this.hinta = hinta;
		this.kuva = kuva;
	}

	public Auto() {
		super();
	}

	public Long getAutoid() {
		return autoid;
	}

	public void setAutoid(Long autoid) {
		this.autoid = autoid;
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

	public int getVuosi() {
		return vuosi;
	}

	public void setVuosi(int vuosi) {
		this.vuosi = vuosi;
	}
	
	public String getRekno() {
		return rekno;
	}

	public void setRekno(String rekno) {
		this.rekno = rekno;
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
		return "Auto [autoid=" + autoid + ", merkki=" + merkki + ", malli=" + malli + ", rekno=" + rekno + ", vuosi=" + vuosi + ", tiedot="
				+ tiedot + ", hinta=" + hinta + ", kuva=" + kuva + "]";
	}
	
	
}
