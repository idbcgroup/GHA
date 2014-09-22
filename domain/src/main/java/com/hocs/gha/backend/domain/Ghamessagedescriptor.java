package com.hocs.gha.backend.domain;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ghamessagedescriptor database table.
 * 
 */
@Entity
@NamedQuery(name="Ghamessagedescriptor.findAll", query="SELECT g FROM Ghamessagedescriptor g")
public class Ghamessagedescriptor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer messagetextid;

	private String language;

	private String messageindications;

	private String messagetext;

	private String realm;

	//bi-directional many-to-one association to Ghamessagecode
	@ManyToOne
	@JoinColumn(name="messageid")
	private Ghamessagecode ghamessagecode;

	public Ghamessagedescriptor() {
	}

	public Integer getMessagetextid() {
		return this.messagetextid;
	}

	public void setMessagetextid(Integer messagetextid) {
		this.messagetextid = messagetextid;
	}

	public String getLanguage() {
		return this.language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getMessageindications() {
		return this.messageindications;
	}

	public void setMessageindications(String messageindications) {
		this.messageindications = messageindications;
	}

	public String getMessagetext() {
		return this.messagetext;
	}

	public void setMessagetext(String messagetext) {
		this.messagetext = messagetext;
	}

	public String getRealm() {
		return this.realm;
	}

	public void setRealm(String realm) {
		this.realm = realm;
	}

	public Ghamessagecode getGhamessagecode() {
		return this.ghamessagecode;
	}

	public void setGhamessagecode(Ghamessagecode ghamessagecode) {
		this.ghamessagecode = ghamessagecode;
	}

}