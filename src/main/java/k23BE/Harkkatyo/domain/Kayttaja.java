package k23BE.Harkkatyo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="users")
public class Kayttaja {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long kayttajaid;
	private String nimi;
	private String rooli;
	@Column(name = "username", nullable = false, unique = true)
	private String username;
	@Column(name = "salasana", nullable = false)
	private String salasana;
	
	public Kayttaja(String nimi, String rooli, String username, String salasana) {
		super();
		this.nimi = nimi;
		this.rooli = rooli;
		this.username = username;
		this.salasana = salasana;
	}
	
	public Kayttaja(String username, String salasana) {
		super();
		this.username = username;
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
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getSalasana() {
		return salasana;
	}

	public void setSalasana(String salasana) {
		this.salasana = salasana;
	}

//	@Override
//	public String toString() {
//		return "Kayttaja [kayttajaid=" + kayttajaid + ", nimi=" + nimi + ", rooli=" + rooli + ", username=" + username
//				+ ", salasana=" + salasana + "]";
//	}
	
	
	
	
}
