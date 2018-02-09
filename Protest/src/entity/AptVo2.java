package entity;

public class AptVo2 {
	int no;
	String sigungu;
	String bunji;
	String danji;
	double myunjuk;
	int cheung;
	int gunchook;
	String doromyung;

	public AptVo2() {
		super();
	}

	public AptVo2(int no, String sigungu, String bunji, String danji, double myunjuk, int cheung, int gunchook,
			String doromyung) {
		super();
		this.no = no;
		this.sigungu = sigungu;
		this.bunji = bunji;
		this.danji = danji;
		this.myunjuk = myunjuk;
		this.cheung = cheung;
		this.gunchook = gunchook;
		this.doromyung = doromyung;
	}

	
	public AptVo2(int no, String sigungu, String bunji, String danji, double myunjuk, int cheung, int gunchook) {
		super();
		this.no = no;
		this.sigungu = sigungu;
		this.bunji = bunji;
		this.danji = danji;
		this.myunjuk = myunjuk;
		this.cheung = cheung;
		this.gunchook = gunchook;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getSigungu() {
		return sigungu;
	}

	public void setSigungu(String sigungu) {
		this.sigungu = sigungu;
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

	@Override
	public String toString() {
		return "AptVo2 [no=" + no + ", sigungu=" + sigungu + ", bunji=" + bunji + ", danji=" + danji + ", myunjuk="
				+ myunjuk + ", cheung=" + cheung + ", gunchook=" + gunchook + ", doromyung=" + doromyung + "]";
	}



}
