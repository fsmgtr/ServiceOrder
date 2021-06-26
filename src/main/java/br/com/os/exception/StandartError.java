package br.com.os.exception;

import java.io.Serializable;

public class StandartError  implements Serializable{

	 
	private static final long serialVersionUID = 1L;
	private Long timestamp;
	private Integer satus;
	private String error;

	public StandartError() {
		super();
	}

	public StandartError(Long timestamp, Integer satus, String error) {
		super();
		this.timestamp = timestamp;
		this.satus = satus;
		this.error = error;
	}

	public Long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}

	public Integer getSatus() {
		return satus;
	}

	public void setSatus(Integer satus) {
		this.satus = satus;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

}
