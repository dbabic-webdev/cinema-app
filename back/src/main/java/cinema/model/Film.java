package cinema.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.ParamDef;
import org.hibernate.annotations.SQLDelete;

@Entity
@SQLDelete(sql = "UPDATE film SET deleted = true WHERE id=?")
@FilterDef(name = "deletedFilmFilter", parameters = @ParamDef (name="isDeleted", type = "boolean"))
@Filter(name = "deletedFilmFilter", condition = "deleted = :isDeleted")
public class Film {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column
    private String naziv;
    
    @Column
    private String reziser;
    
    @Column
    private String glumci;
    
    @Column
    private String zanrovi;
    
    @Column
    private int trajanje;
    
    @Column
    private String distributer;
    
    @Column(name="zemlja_porekla")
    private String zemljaPorekla;
    
    @Column(name="godina_proizvodnje")
    private int godinaProizvodnje;
    
    @Column
    private String opis;
    
    @OneToMany(mappedBy = "film", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Projekcija> projekcije = new HashSet<>();
    
    @Column
    private boolean deleted = Boolean.FALSE;
    
	public Film() {
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

	public String getReziser() {
		return reziser;
	}

	public void setReziser(String reziser) {
		this.reziser = reziser;
	}

	public String getGlumci() {
		return glumci;
	}

	public void setGlumci(String glumci) {
		this.glumci = glumci;
	}

	public String getZanrovi() {
		return zanrovi;
	}

	public void setZanrovi(String zanrovi) {
		this.zanrovi = zanrovi;
	}

	public int getTrajanje() {
		return trajanje;
	}

	public void setTrajanje(int trajanje) {
		this.trajanje = trajanje;
	}

	public String getDistributer() {
		return distributer;
	}

	public void setDistributer(String distributer) {
		this.distributer = distributer;
	}

	public String getZemljaPorekla() {
		return zemljaPorekla;
	}

	public void setZemljaPorekla(String zemljaPorekla) {
		this.zemljaPorekla = zemljaPorekla;
	}

	public int getGodinaProizvodnje() {
		return godinaProizvodnje;
	}

	public void setGodinaProizvodnje(int godinaProizvodnje) {
		this.godinaProizvodnje = godinaProizvodnje;
	}

	public String getOpis() {
		return opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

	public Set<Projekcija> getProjekcije() {
		return projekcije;
	}

	public void setProjekcije(Set<Projekcija> projekcije) {
		this.projekcije = projekcije;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}
	
}
