package cinema.web.dto;

import java.util.HashSet;
import java.util.Set;

public class SalaDTO {
	
	private Long id;
	private String naziv;
	private Set <SedisteDTO> sedista = new HashSet<>();
	
	
	public SalaDTO() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public Set<SedisteDTO> getSedista() {
		return sedista;
	}

	public void setSedista(Set<SedisteDTO> sedista) {
		this.sedista = sedista;
	}

}
