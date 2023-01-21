/*
 * Esta clase representa los departamentos en JAVA
 */


public class Departamentos implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private byte numerodep;
	private String nombredep;
	private String localidaddep;

	public Departamentos() {
	}

	public Departamentos(byte numerodep) {
		this.numerodep = numerodep;
	}

	public Departamentos(byte numerodep, String nombredep, String localidaddep) {
		this.numerodep = numerodep;
		this.nombredep = nombredep;
		this.localidaddep = localidaddep;
	}

	public byte getNumerodep() {
		return this.numerodep;
	}

	public void setNumerodep(byte numerodep) {
		this.numerodep = numerodep;
	}

	public String getNombredep() {
		return this.nombredep;
	}

	public void setNombredep(String nombredep) {
		this.nombredep = nombredep;
	}

	public String getLocalidaddep() {
		return this.localidaddep;
	}

	public void setLocalidaddep(String localidaddep) {
		this.localidaddep = localidaddep;
	}

}
