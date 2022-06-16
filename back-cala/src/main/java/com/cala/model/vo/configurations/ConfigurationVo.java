package com.cala.model.vo.configurations;

import java.util.List;
import java.util.stream.Collectors;

import com.cala.model.entities.configurations.Configuration;
import com.cala.model.vo.global.AbstractVo;

public class ConfigurationVo extends AbstractVo{
	
	private String value;
	
	private String name;
	
	private String code;
	
	public ConfigurationVo() {}
	
	public ConfigurationVo(Configuration config) {
		setId(config.getId());
		setValue(config.getValue());
		setName(config.getName());
	}
	
	public ConfigurationVo(String name, String value) {
		setValue(value);
		setName(name);
	}
	
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static List<ConfigurationVo> createListVo(List<Configuration> list) {
		return list.stream().map(config -> new ConfigurationVo(config)).collect(Collectors.toList());
	}

	public static ConfigurationVo createVo(Configuration config) {
		if (config != null) {
			return new ConfigurationVo(config);
		}
		return null;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
}
