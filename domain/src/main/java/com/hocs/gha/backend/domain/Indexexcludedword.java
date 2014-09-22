package com.hocs.gha.backend.domain;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the indexexcludedword database table.
 * 
 */
@Entity
@NamedQuery(name="Indexexcludedword.findAll", query="SELECT i FROM Indexexcludedword i")
public class Indexexcludedword implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer indexexcludedwordid;

	private String language;

	private String realm;

	private String word;

	private String wordtype;

	public Indexexcludedword() {
	}

	public Integer getIndexexcludedwordid() {
		return this.indexexcludedwordid;
	}

	public void setIndexexcludedwordid(Integer indexexcludedwordid) {
		this.indexexcludedwordid = indexexcludedwordid;
	}

	public String getLanguage() {
		return this.language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getRealm() {
		return this.realm;
	}

	public void setRealm(String realm) {
		this.realm = realm;
	}

	public String getWord() {
		return this.word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public String getWordtype() {
		return this.wordtype;
	}

	public void setWordtype(String wordtype) {
		this.wordtype = wordtype;
	}

}