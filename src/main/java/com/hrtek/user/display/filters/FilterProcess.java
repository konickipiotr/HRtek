package com.hrtek.user.display.filters;

import java.util.List;

public class FilterProcess<T, V> {
	
	private V filters;
	private TextFilterOperaton<T, V> textOpertation;
	private DateFilterOperation<T, V> dateOperation;
	private OtherFilterOperation<T, V> otheOperation;

	public FilterProcess(V filters) {
		this.filters = filters;
	}
	
	public FilterProcess<T, V> setTextOpertation(TextFilterOperaton<T, V> textOpertation){
		this.textOpertation = textOpertation;
		this.textOpertation.setFilter(filters);
		return this;
	}
	
	public FilterProcess<T, V> setDateOperation(DateFilterOperation<T, V> dateOperation){
		this.dateOperation = dateOperation;
		this.dateOperation.setFilter(filters);
		return this;
	}
	
	public FilterProcess<T, V> setOtherFiletrOperation(OtherFilterOperation<T, V> otheOperation){
		this.otheOperation = otheOperation;
		this.otheOperation.setFilter(filters);
		return this;
	}
	
	
	public List<T> filter(List<T> list){
		list = textOpertation.textprocess(list);
		list = dateOperation.datefilter(list);
		list = otheOperation.filterother(list);
		return list;
	}
}
