package com.hocs.gha.backend.facade.catalog;

import javax.ejb.Remote;

import com.hocs.gha.backend.facade.catalog.dto.CatalogDTO;
import com.hocs.gha.backend.facade.catalog.dto.ComboBoxDataLoadDTO;

@Remote
public interface InstitutionComboServiceRemote {
	public static final String JNDI_NAME = "java:global/backend-1.0/facade-1.0/InstitutionComboService";

	public ComboBoxDataLoadDTO getInstitutionsCombo(CatalogDTO dto);
}
