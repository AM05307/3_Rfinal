package dao;

public interface AptDao {

	//int insertApt(String si, String gun, String gu, String bunji, String danji, double myunjuk,int cheung, int gunchook, String doromyung);
	int insertApt(int no ,String si, String gun, String gu, String bunji, String danji, double myunjuk,int cheung, int gunchook, String doromyung);
	int insertApt3(int no, String sigungu, String bunji, String danji, double myunjuk,	int cheung, int gunchook);
	int insertJun(int no,String junwol, String gyeyak, int bojeung, int wolse);
}
