package com.hrtek.model.worker;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
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
}
