package com.akeys.mdf.vo;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


/**
 * The Class SchemeVo.
 *
 * @author Ankit Sood May 2, 2017
 */
@XmlRootElement(name = "scheme")
public class SchemeVo {

	private String name;
	private String text;

	/**
	 * Instantiates a new message.
	 */
	public SchemeVo(){
		
	}
	
	/**
	 * Instantiates a new message.
	 *
	 * @param name
	 *            the name
	 * @param text
	 *            the text
	 */
	public SchemeVo(String name, String text) {
		this.name = name;
		this.text = text;
	}

	@XmlElement
	public String getName() {
		return name;
	}
	
	@XmlElement
	public String getText() {
		return text;
	}

}
