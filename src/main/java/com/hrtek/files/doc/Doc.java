package com.hrtek.files.doc;

public interface Doc<T> {

	void prepareDoc();
	T getDoc();
	String getFilepath();
	String getFilename();
	DocType getType();
}
