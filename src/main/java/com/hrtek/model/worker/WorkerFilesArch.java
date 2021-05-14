package com.hrtek.model.worker;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class WorkerFilesArch {
	
	@Id
	@GeneratedValue
	private Long id;
	private Long workerid;
	private String filename;
	private String path;
	private int type;
	
	public WorkerFilesArch() {
	}

	public WorkerFilesArch(Long workerid, String filename, String path, int type) {
		this.workerid = workerid;
		this.filename = filename;
		this.path = path;
		this.type = type;
	}
	
	public WorkerFilesArch(WorkerFiles wf) {
		this.workerid = wf.getId();
		this.filename = wf.getFilename();
		this.path = wf.getPath();
		this.type = wf.getType();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getWorkerid() {
		return workerid;
	}

	public void setWorkerid(Long workerid) {
		this.workerid = workerid;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}
}
