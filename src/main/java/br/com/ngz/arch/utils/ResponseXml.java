package br.com.ngz.arch.utils;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author anogu
 */
@XmlRootElement
public class ResponseXml {
    
    @XmlElement(required = false)
    private String fault;
    @XmlElement(required = false)
    private String code;

    public String getFault() {
        return fault;
    }

    public void setFault(String fault) {
        this.fault = fault;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
    
}
