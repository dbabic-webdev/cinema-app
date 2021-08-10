package cinema.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

@Entity
public class Sala {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column
    private String naziv;
    
    
    @ManyToMany
    @JoinTable(name = "sala_tip", joinColumns = @JoinColumn(name = "sala_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "tip_id", referencedColumnName = "id"))
    private Set <Tip> tipovi = new HashSet<>();
    
    @OneToMany(mappedBy = "sala", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set <Sediste> sedista = new HashSet<>();
    
    
    @OneToMany(mappedBy = "sala", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List <Projekcija> projekcije = new ArrayList<>();


	public Sala() {
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


	public Set<Tip> getTipovi() {
		return tipovi;
	}


	public void setTipovi(Set<Tip> tipovi) {
		this.tipovi = tipovi;
	}


	public Set<Sediste> getSedista() {
		return sedista;
	}


	public void setSedista(Set<Sediste> sedista) {
		this.sedista = sedista;
	}


	public List<Projekcija> getProjekcije() {
		return projekcije;
	}


	public void setProjekcije(List<Projekcija> projekcije) {
		this.projekcije = projekcije;
	}
    
    

}
