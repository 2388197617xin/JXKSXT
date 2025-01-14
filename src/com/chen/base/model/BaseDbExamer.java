package com.chen.base.model;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings("serial")
public abstract class BaseDbExamer<M extends BaseDbExamer<M>> extends Model<M> implements IBean {

	public void setId(Integer id) {
		set("id", id);
	}

	public Integer getId() {
		return get("id");
	}

	public void setName(String name) {
		set("name", name);
	}

	public String getName() {
		return get("name");
	}

	public void setSex(String sex) {
		set("sex", sex);
	}

	public String getSex() {
		return get("sex");
	}

	public void setIdCard(String idCard) {
		set("id_card", idCard);
	}

	public String getIdCard() {
		return get("id_card");
	}

	public void setSchool(String school) {
		set("school", school);
	}

	public String getSchool() {
		return get("school");
	}

	public void setImg(String img) {
		set("img", img);
	}

	public String getImg() {
		return get("img");
	}

	public void setPcId(Integer pcId) {
		set("pc_id", pcId);
	}

	public Integer getPcId() {
		return get("pc_id");
	}

}
