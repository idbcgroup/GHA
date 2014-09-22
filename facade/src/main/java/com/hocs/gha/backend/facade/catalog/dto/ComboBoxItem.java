package com.hocs.gha.backend.facade.catalog.dto;

import java.io.Serializable;

public class ComboBoxItem implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2152741315121885486L;

	private String value;

	private String caption;

	public java.lang.String getValue() {
		return value;
	}

	public void setValue(java.lang.String newValue) {
		value = newValue;
	}

	public java.lang.String getCaption() {
		return caption;
	}

	public void setCaption(java.lang.String newCaption) {
		caption = newCaption;
	}

}