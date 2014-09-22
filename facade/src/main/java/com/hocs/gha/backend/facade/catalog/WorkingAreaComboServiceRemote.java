package com.hocs.gha.backend.facade.catalog;

import javax.ejb.Remote;

import com.hocs.gha.backend.facade.catalog.dto.CatalogDTO;
import com.hocs.gha.backend.facade.catalog.dto.ComboBoxDataLoadDTO;

/**
 * @author emiliot
 * 
 */
@Remote
public interface WorkingAreaComboServiceRemote {
	public static final String JNDI_NAME = "java:global/backend-1.0/facade-1.0/WorkingAreaComboService";

	/**
	 * @param dto
	 * @return
	 */
	public ComboBoxDataLoadDTO getWorkingAreasCombo(CatalogDTO dto);
}
