package com.hocs.gha.backend.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the standardagency database table.
 * 
 */
@Entity
@NamedQuery(name="Standardagency.findAll", query="SELECT s FROM Standardagency s")
public class Standardagency implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String stdagencycode;

	private String stdagencycountry;

	private String stdagencyname;

	//bi-directional many-to-one association to Bdi
	@OneToMany(mappedBy="standardagency")
	private List<Bdi> bdis;

	public Standardagency() {
	}

	public String getStdagencycode() {
		return this.stdagencycode;
	}

	public void setStdagencycode(String stdagencycode) {
		this.stdagencycode = stdagencycode;
	}

	public String getStdagencycountry() {
		return this.stdagencycountry;
	}

	public void setStdagencycountry(String stdagencycountry) {
		this.stdagencycountry = stdagencycountry;
	}

	public String getStdagencyname() {
		return this.stdagencyname;
	}

	public void setStdagencyname(String stdagencyname) {
		this.stdagencyname = stdagencyname;
	}

	public List<Bdi> getBdis() {
		return this.bdis;
	}

	public void setBdis(List<Bdi> bdis) {
		this.bdis = bdis;
	}

	public Bdi addBdi(Bdi bdi) {
		getBdis().add(bdi);
		bdi.setStandardagency(this);

		return bdi;
	}

	public Bdi removeBdi(Bdi bdi) {
		getBdis().remove(bdi);
		bdi.setStandardagency(null);

		return bdi;
	}

}