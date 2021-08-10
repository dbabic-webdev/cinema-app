package cinema.web.dto;

import java.util.ArrayList;
import java.util.List;

public class KartaDTO {
	
	private Long id;	
	private List <SedisteDTO> sedista = new ArrayList<>();
	private Long projekcijaId;
	private String projekcijaDatum;
	private String projekcijaFilm;
	private String datum;
	
	public KartaDTO() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDatum() {
		return datum;
	}

	public void setDatum(String datum) {
		this.datum = datum;
	}

	public Long getProjekcijaId() {
		return projekcijaId;
	}

	public void setProjekcijaId(Long projekcijaId) {
		this.projekcijaId = projekcijaId;
	}

	public String getProjekcijaDatum() {
		return projekcijaDatum;
	}

	public void setProjekcijaDatum(String projekcijaDatum) {
		this.projekcijaDatum = projekcijaDatum;
	}

	public String getProjekcijaFilm() {
		return projekcijaFilm;
	}

	public void setProjekcijaFilm(String projekcijaFilm) {
		this.projekcijaFilm = projekcijaFilm;
	}

	public List<SedisteDTO> getSedista() {
		return sedista;
	}

	public void setSedista(List<SedisteDTO> sedista) {
		this.sedista = sedista;
	}
}
