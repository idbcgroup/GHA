package com.hocs.gha.backend.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the ghamessagecode database table.
 * 
 */
@Entity
@NamedQuery(name="Ghamessagecode.findAll", query="SELECT g FROM Ghamessagecode g")
public class Ghamessagecode implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer messageid;

	private String messagetext;

	private String messagetype;

	//bi-directional many-to-one association to Ghamessagedescriptor
	@OneToMany(mappedBy="ghamessagecode")
	private List<Ghamessagedescriptor> ghamessagedescriptors;

	public Ghamessagecode() {
	}

	public Integer getMessageid() {
		return this.messageid;
	}

	public void setMessageid(Integer messageid) {
		this.messageid = messageid;
	}

	public String getMessagetext() {
		return this.messagetext;
	}

	public void setMessagetext(String messagetext) {
		this.messagetext = messagetext;
	}

	public String getMessagetype() {
		return this.messagetype;
	}

	public void setMessagetype(String messagetype) {
		this.messagetype = messagetype;
	}

	public List<Ghamessagedescriptor> getGhamessagedescriptors() {
		return this.ghamessagedescriptors;
	}

	public void setGhamessagedescriptors(List<Ghamessagedescriptor> ghamessagedescriptors) {
		this.ghamessagedescriptors = ghamessagedescriptors;
	}

	public Ghamessagedescriptor addGhamessagedescriptor(Ghamessagedescriptor ghamessagedescriptor) {
		getGhamessagedescriptors().add(ghamessagedescriptor);
		ghamessagedescriptor.setGhamessagecode(this);

		return ghamessagedescriptor;
	}

	public Ghamessagedescriptor removeGhamessagedescriptor(Ghamessagedescriptor ghamessagedescriptor) {
		getGhamessagedescriptors().remove(ghamessagedescriptor);
		ghamessagedescriptor.setGhamessagecode(null);

		return ghamessagedescriptor;
	}

}