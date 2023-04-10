package k23BE.Harkkatyo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class Projekti {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "nimi", nullable = false)
	private String nimi;
	private String osat;
	private String kuvaus;
	private double kustannukset;
	
	@ManyToOne
	@JoinColumn(name = "autoid")
	private Auto auto;
	
	@ManyToOne
	@JoinColumn(name = "tilaid")
	private Tila tila;

	// auto + tila
	public Projekti(String nimi, String osat, String kuvaus, double kustannukset, Auto auto, Tila tila) {
		super();
		this.nimi = nimi;
		this.osat = osat;
		this.kuvaus = kuvaus;
		this.kustannukset = kustannukset;
		this.auto = auto;
		this.tila = tila;
	}
	
	// pelkkä projekti
	public Projekti(String nimi, String osat, String kuvaus, double kustannukset) {
		super();
		this.nimi = nimi;
		this.osat = osat;
		this.kuvaus = kuvaus;
		this.kustannukset = kustannukset;
	}

	public Projekti() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNimi() {
		return nimi;
	}

	public void setNimi(String nimi) {
		this.nimi = nimi;
	}

	public String getOsat() {
		return osat;
	}

	public void setOsat(String osat) {
		this.osat = osat;
	}

	public String getKuvaus() {
		return kuvaus;
	}

	public void setKuvaus(String kuvaus) {
		this.kuvaus = kuvaus;
	}

	public double getKustannukset() {
		return kustannukset;
	}

	public void setKustannukset(double kustannukset) {
		this.kustannukset = kustannukset;
	}

	public Auto getAuto() {
		return auto;
	}

	public void setAuto(Auto auto) {
		this.auto = auto;
	}

	public Tila getTila() {
		return tila;
	}

	public void setTila(Tila tila) {
		this.tila = tila;
	}

	@Override
	public String toString() {
		return "Projekti [id=" + id + ", nimi=" + nimi + ", osat=" + osat + ", kuvaus=" + kuvaus + ", kustannukset="
				+ kustannukset + ", auto=" + auto + ", tila=" + tila + "]";
	}

}
