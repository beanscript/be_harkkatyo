package k23BE.Harkkatyo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Kayttaja {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long kayttajaid;
	private String nimi;
	@Column(name = "rooli", nullable = false)
	private String rooli;
	@Column(name = "tunnus", nullable = false, unique = true)
	private String tunnus;
	@Column(name = "salasana", nullable = false)
	private String salasana;
	
	public Kayttaja(String nimi, String rooli, String tunnus, String salasana) {
		super();
		this.nimi = nimi;
		this.rooli = rooli;
		this.tunnus = tunnus;
		this.salasana = salasana;
	}
	
	public Kayttaja(String tunnus, String salasana) {
		super();
		this.tunnus = tunnus;
		this.salasana = salasana;
	}

	public Kayttaja() {
	}

	public Long getKayttajaid() {
		return kayttajaid;
	}

	public void setKayttajaid(Long kayttajaid) {
		this.kayttajaid = kayttajaid;
	}

	public String getNimi() {
		return nimi;
	}

	public void setNimi(String nimi) {
		this.nimi = nimi;
	}

	public String getRooli() {
		return rooli;
	}

	public void setRooli(String rooli) {
		this.rooli = rooli;
	}

	public String getUsername() {
		return tunnus;
	}

	public void setUsername(String tunnus) {
		this.tunnus = tunnus;
	}

	public String getSalasana() {
		return salasana;
	}

	public void setSalasana(String salasana) {
		this.salasana = salasana;
	}

	@Override
	public String toString() {
		return "Kayttaja [kayttajaid=" + kayttajaid + ", nimi=" + nimi + ", rooli=" + rooli + ", tunnus=" + tunnus
				+ ", salasana=" + salasana + "]";
	}
	
	
	
	
}
