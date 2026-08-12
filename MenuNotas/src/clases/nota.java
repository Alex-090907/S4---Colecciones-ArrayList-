package clases;

public class nota {
String ciestudiante;
double n1;
double n2;
double n3;
double ex;
	public nota()
	{
		this.ciestudiante="";
		this.n1=0;
		this.n2=0;
		this.n3=0;
		this.ex=0;
	}
	public String getCiestudiante() {
		return ciestudiante;
	}
	public void setCiestudiante(String ciestudiante) {
		this.ciestudiante = ciestudiante;
	}
	public double getN1() {
		return n1;
	}
	public void setN1(double n1) {
		this.n1 = n1;
	}
	public double getN2() {
		return n2;
	}
	public void setN2(double n2) {
		this.n2 = n2;
	}
	public double getN3() {
		return n3;
	}
	public void setN3(double n3) {
		this.n3 = n3;
	}
	public double getEx() {
		return ex;
	}
	public void setEx(double ex) {
		this.ex = ex;
	}
}