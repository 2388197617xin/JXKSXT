package com.chen.base.model;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings("serial")
public abstract class BaseAdminTable<M extends BaseAdminTable<M>> extends Model<M> implements IBean {

	public void setId(Integer id) {
		set("id", id);
	}

	public Integer getId() {
		return get("id");
	}

	public void setUsername(String username) {
		set("username", username);
	}

	public String getUsername() {
		return get("username");
	}

	public void setPassword(String password) {
		set("password", password);
	}

	public String getPassword() {
		return get("password");
	}

}
