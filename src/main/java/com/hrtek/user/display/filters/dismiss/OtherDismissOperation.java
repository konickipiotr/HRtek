package com.hrtek.user.display.filters.dismiss;

import java.util.List;

import com.hrtek.user.display.filters.DismissedFilters;
import com.hrtek.user.display.filters.OtherFilterOperation;
import com.hrtek.user.display.views.DismissedView;

public class OtherDismissOperation extends OtherFilterOperation<DismissedView, DismissedFilters> {

	private DismissedFilters bf;
	
	@Override
	public void setFilter(DismissedFilters v) {
		this.bf = v;
	}

	@Override
	public List<DismissedView> filterother(List<DismissedView> list) {
		return list;
	}

}
