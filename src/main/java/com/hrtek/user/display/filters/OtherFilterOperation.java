package com.hrtek.user.display.filters;

import java.util.List;

public abstract class OtherFilterOperation<T, V> {

	public abstract void setFilter(V v);
	public abstract List<T> filterother(List<T> list);
}
