package com.hocs.gha.backend.facade.catalog.dto;

import java.io.Serializable;
import java.util.ArrayList;

public class ComboBoxDataLoadDTO extends CatalogDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5510281379998496025L;

	public java.util.List<ComboBoxItem> comboBoxItems = new ArrayList<>();

	public java.util.List<ComboBoxItem> getComboBoxItems() {
		return comboBoxItems;
	}

	public void setComboBoxItem(java.util.List<ComboBoxItem> comboBoxItems) {
		this.comboBoxItems = comboBoxItems;
	}

}