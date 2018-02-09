package entity;

public class JunVo {
	int no;
	String junwol;
	String gyeyak;
	int bojeung;
	int wolse;
	
	public JunVo() {
		super();
	}

	public JunVo(int no,String junwol, String gyeyak, int bojeung, int wolse) {
		super();
		this.no= no;
		this.junwol = junwol;
		this.gyeyak = gyeyak;
		this.bojeung = bojeung;
		this.wolse = wolse;
	}

	public String getJunwol() {
		return junwol;
	}

	public void setJunwol(String junwol) {
		this.junwol = junwol;
	}

	public String getGyeyak() {
		return gyeyak;
	}

	public void setGyeyak(String gyeyak) {
		this.gyeyak = gyeyak;
	}

	public int getBojeung() {
		return bojeung;
	}

	public void setBojeung(int bojeung) {
		this.bojeung = bojeung;
	}

	public int getWolse() {
		return wolse;
	}

	public void setWolse(int wolse) {
		this.wolse = wolse;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	@Override
	public String toString() {
		return "JunVo [no=" + no + ", junwol=" + junwol + ", gyeyak=" + gyeyak + ", bojeung=" + bojeung + ", wolse="
				+ wolse + "]";
	}

	
}
