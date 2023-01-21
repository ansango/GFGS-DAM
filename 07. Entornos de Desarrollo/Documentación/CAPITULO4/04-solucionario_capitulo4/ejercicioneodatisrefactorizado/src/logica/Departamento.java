package logica;

public class Departamento {
	private int dept_no;
	private String dnombre;
	private String loc;

	public Departamento(int dept_no, String dnombre, String loc) {
		this.dept_no = dept_no;
		this.dnombre = dnombre;
		this.loc = loc;
	}

	public int getDept_no() {
		return dept_no;
	}

	public void setDept_no(int dept_no) {
		this.dept_no = dept_no;
	}

	public String getDnombre() {
		return dnombre;
	}

	public void setDnombre(String dnombre) {
		this.dnombre = dnombre;
	}

	public String getLoc() {
		return loc;
	}

	public void setLoc(String loc) {
		this.loc = loc;
	}
}