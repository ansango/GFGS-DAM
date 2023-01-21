/*
 * Esta clase representa los empleados en JAVA
 */


import java.util.Date;


public class Empleados implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private short numeroemple;
	private String apellidoemple;
	private String oficioemple;
	private Short diremple;
	private Date altaemple;
	private Float salarioemple;
	private Float comisionemple;
	private byte numerodep;

	public Empleados() {
	}

	public Empleados(short numeroemple, byte numerodep) {
		this.numeroemple = numeroemple;
		this.numerodep = numerodep;
	}

	public Empleados(short numeroemple, String apellidoemple, String oficioemple, Short diremple, Date altaemple,
			Float salarioemple, Float comisionemple, byte numerodep) {
		this.numeroemple = numeroemple;
		this.apellidoemple = apellidoemple;
		this.oficioemple = oficioemple;
		this.diremple = diremple;
		this.altaemple = altaemple;
		this.salarioemple = salarioemple;
		this.comisionemple = comisionemple;
		this.numerodep = numerodep;
	}

	public short getNumeroemple() {
		return this.numeroemple;
	}

	public void setNumeroemple(short numeroemple) {
		this.numeroemple = numeroemple;
	}

	public String getApellidoemple() {
		return this.apellidoemple;
	}

	public void setApellidoemple(String apellidoemple) {
		this.apellidoemple = apellidoemple;
	}

	public String getOficioemple() {
		return this.oficioemple;
	}

	public void setOficioemple(String oficioemple) {
		this.oficioemple = oficioemple;
	}

	public Short getDiremple() {
		return this.diremple;
	}

	public void setDiremple(Short diremple) {
		this.diremple = diremple;
	}

	public Date getAltaemple() {
		return this.altaemple;
	}

	public void setAltaemple(Date altaemple) {
		this.altaemple = altaemple;
	}

	public Float getSalarioemple() {
		return this.salarioemple;
	}

	public void setSalarioemple(Float salarioemple) {
		this.salarioemple = salarioemple;
	}

	public Float getComisionemple() {
		return this.comisionemple;
	}

	public void setComisionemple(Float comisionemple) {
		this.comisionemple = comisionemple;
	}

	public byte getNumerodep() {
		return this.numerodep;
	}

	public void setNumerodep(byte numerodep) {
		this.numerodep = numerodep;
	}

}
