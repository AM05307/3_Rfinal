package entity;

public class AptVo {
	int no;
	String si;
	String gun;
	String gu;
	String bunji;
	String danji;
	double myunjuk;
	int cheung;
	int gunchook;
	String doromyung;

	public AptVo() {
		super();
	}

	public AptVo(int no,String si, String gun, String gu, String bunji, String danji, double myunjuk, int cheung,
			int gunchook, String doromyung) {
		super();
		this.no=no;
		this.si = si;
		this.gun = gun;
		this.gu = gu;
		this.bunji = bunji;
		this.danji = danji;
		this.myunjuk = myunjuk;
		this.cheung = cheung;
		this.gunchook = gunchook;
		this.doromyung = doromyung;
	}
	
	

	public AptVo(int no, String si, String gun, String gu, String bunji, String danji, double myunjuk, int cheung,
			int gunchook) {
		super();
		this.no = no;
		this.si = si;
		this.gun = gun;
		this.gu = gu;
		this.bunji = bunji;
		this.danji = danji;
		this.myunjuk = myunjuk;
		this.cheung = cheung;
		this.gunchook = gunchook;
	}

	public String getSi() {
		return si;
	}

	public void setSi(String si) {
		this.si = si;
	}

	public String getGun() {
		return gun;
	}

	public void setGun(String gun) {
		this.gun = gun;
	}

	public String getGu() {
		return gu;
	}

	public void setGu(String gu) {
		this.gu = gu;
	}

	public String getBunji() {
		return bunji;
	}

	public void setBunji(String bunji) {
		this.bunji = bunji;
	}

	public String getDanji() {
		return danji;
	}

	public void setDanji(String danji) {
		this.danji = danji;
	}

	public double getMyunjuk() {
		return myunjuk;
	}

	public void setMyunjuk(double myunjuk) {
		this.myunjuk = myunjuk;
	}

	public int getCheung() {
		return cheung;
	}

	public void setCheung(int cheung) {
		this.cheung = cheung;
	}

	public int getGunchook() {
		return gunchook;
	}

	public void setGunchook(int gunchook) {
		this.gunchook = gunchook;
	}

	public String getDoromyung() {
		return doromyung;
	}

	public void setDoromyung(String doromyung) {
		this.doromyung = doromyung;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	@Override
	public String toString() {
		return "AptVo [no=" + no + ", si=" + si + ", gun=" + gun + ", gu=" + gu + ", bunji=" + bunji + ", danji="
				+ danji + ", myunjuk=" + myunjuk + ", cheung=" + cheung + ", gunchook=" + gunchook + ", doromyung="
				+ doromyung + "]";
	}

	

}
