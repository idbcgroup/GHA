package com.hocs.gha.backend.facade.catalog;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import com.hocs.gha.backend.facade.catalog.dto.CatalogDTO;
import com.hocs.gha.backend.facade.catalog.dto.ComboBoxDataLoadDTO;
import com.hocs.gha.backend.facade.catalog.dto.ComboBoxItem;

/**
 * Session Bean implementation class InstitutionComboService
 */
@Stateless
public class InstitutionComboService implements InstitutionComboServiceRemote {

	@Override
	public ComboBoxDataLoadDTO getInstitutionsCombo(CatalogDTO dto) {
		// TODO: por ahora solo es dummy
		ComboBoxDataLoadDTO res = new ComboBoxDataLoadDTO();

		String values[] = new String[] { "v1", "v2", "...", "vn" };
		String caption[] = new String[] { "c1", "c2", "...", "cn" };
		List<ComboBoxItem> items = new ArrayList<>();

		for (int i = 0, n = values.length; i < n; ++i) {
			ComboBoxItem item = new ComboBoxItem();
			item.setCaption(caption[i]);
			item.setValue(values[i]);
			items.add(item);
		}

		res.setComboBoxItem(items);
		return res;
	}

}
