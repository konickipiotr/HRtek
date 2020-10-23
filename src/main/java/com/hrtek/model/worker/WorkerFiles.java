package com.hrtek.model.worker;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class WorkerFiles {

	@Id
	@GeneratedValue
	private Long id;
	private Long workerid;
	private String filename;
	private String path;
	private int type;
	
	public WorkerFiles() {
	}

	public WorkerFiles(Long workerid, String filename, String path, int type) {
		this.workerid = workerid;
		this.filename = filename;
		this.path = path;
		this.type = type;
	}

	public WorkerFiles(WorkerFilesArch f) {
		this.workerid = f.getId();
		this.filename = f.getFilename();
		this.path = f.getPath();
		this.type = f.getType();
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

	@Override
	public String toString() {
		return "WorkerFiles [id=" + id + ", workerid=" + workerid + ", filename=" + filename + ", path=" + path
				+ ", type=" + type + "]";
	}
}
