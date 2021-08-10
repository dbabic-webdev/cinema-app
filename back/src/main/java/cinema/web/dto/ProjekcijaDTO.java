package cinema.web.dto;

public class ProjekcijaDTO {
	
	private Long id;
	private FilmDTO film;
	private TipDTO tip;
	private SalaDTO sala;
	private String datumIVreme;
	private double cena;
	
	public ProjekcijaDTO() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public FilmDTO getFilm() {
		return film;
	}

	public void setFilm(FilmDTO film) {
		this.film = film;
	}

	public TipDTO getTip() {
		return tip;
	}

	public void setTip(TipDTO tip) {
		this.tip = tip;
	}

	public SalaDTO getSala() {
		return sala;
	}

	public void setSala(SalaDTO sala) {
		this.sala = sala;
	}

	public String getDatumIVreme() {
		return datumIVreme;
	}

	public void setDatumIVreme(String datumIVreme) {
		this.datumIVreme = datumIVreme;
	}

	public double getCena() {
		return cena;
	}

	public void setCena(double cena) {
		this.cena = cena;
	}
}
