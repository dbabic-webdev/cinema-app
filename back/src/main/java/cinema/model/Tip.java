package cinema.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Tip {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column
    private String naziv;
    
    @ManyToMany(mappedBy = "tipovi",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private Set <Sala> sale = new HashSet<>();
    
    @OneToMany(mappedBy = "tip", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List <Projekcija> projekcije = new ArrayList<>();

	public Tip() {
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

	public Set<Sala> getSale() {
		return sale;
	}

	public void setSale(Set<Sala> sale) {
		this.sale = sale;
	}

	public List<Projekcija> getProjekcije() {
		return projekcije;
	}

	public void setProjekcije(List<Projekcija> projekcije) {
		this.projekcije = projekcije;
	}
}
