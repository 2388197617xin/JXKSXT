package com.chen.base.model;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings("serial")
public abstract class BaseDbPc<M extends BaseDbPc<M>> extends Model<M> implements IBean {

	public void setId(Integer id) {
		set("id", id);
	}

	public Integer getId() {
		return get("id");
	}

	public void setIP(String IP) {
		set("IP", IP);
	}

	public String getIP() {
		return get("IP");
	}

	public void setPcname(String pcname) {
		set("pcname", pcname);
	}

	public String getPcname() {
		return get("pcname");
	}

	public void setState(Integer state) {
		set("state", state);
	}

	public Integer getState() {
		return get("state");
	}

	public void setNote(String note) {
		set("note", note);
	}

	public String getNote() {
		return get("note");
	}

}
