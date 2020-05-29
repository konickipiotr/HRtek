package com.hrtek.user.display.filters;

import java.util.List;

import com.hrtek.settings.GlobalSettings;
import com.hrtek.user.display.views.BasicView;

public abstract class TextFilterOperaton<T, V> {

	public abstract void setFilter(V v);
	public abstract List<T> textprocess(List<T> list);
	public abstract List<T> textEmpty(List<T> list);
	public abstract List<T> texteauals(List<T> list);
	public abstract List<T> textContains(List<T> list);
	public abstract List<T> textFirstLetters(List<T> list);
	
	protected boolean equals(String field, String text) {
		if(field == null || text == null) return false;
		return field.toLowerCase().equals(text);
	}
	
	protected boolean contains(String field, String text) {
		if(field == null || text == null) return false;
		return field.toLowerCase().contains(text);
	}
	
	protected boolean numletter(String field, String text) {
		if(field == null || text == null) return false;
		return field.toLowerCase().contains(text);
	}
	
	protected String prepareTextLen(String text) {
		text = text.toLowerCase();
		if(text.length() > GlobalSettings.numoffirstletters) {
			return text.substring(0, GlobalSettings.numoffirstletters);
		}
		return text;
	}
}
