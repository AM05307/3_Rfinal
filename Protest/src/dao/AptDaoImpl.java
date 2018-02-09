package dao;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


import entity.AptVo;
import entity.AptVo2;
import entity.JunVo;
import entity.SimVo;

public class AptDaoImpl implements AptDao {

	private static SqlSessionFactory factory = null;

	AptVo av = new AptVo();
	AptVo2 av2= new AptVo2();
	JunVo jv = new JunVo();

	static {
		try {
			String resource = "common/mybatis-config.xml";
			Reader reader = Resources.getResourceAsReader(resource);
			factory = new SqlSessionFactoryBuilder().build(reader);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static SqlSessionFactory getSqlMapClientInstatnce() {
		return factory;

	}

	/*
	 * @Override public int insertApt(String si, String gun, String gu, String
	 * bunji, String danji, double myunjuk,int cheung, int gunchook, String
	 * doromyung) {
	 */

	@Override
	public int insertApt(int no, String si, String gun, String gu, String bunji, String danji, double myunjuk,
			int cheung, int gunchook, String doromyung) {
		SqlSession session = factory.openSession();

		av.setNo(no);
		av.setSi(si);
		av.setGun(gun);
		av.setGu(gu);
		av.setBunji(bunji);
		av.setDanji(danji);
		av.setMyunjuk(myunjuk);
		av.setCheung(cheung);
		av.setGunchook(gunchook);
		av.setDoromyung(doromyung);

		int cnt = session.insert("mybatis.apt.insertapt", av);
		session.commit();
		session.close();

		return cnt;
	}


	public int insertApt2(int no, String sigungu, String bunji, String danji, double myunjuk,
			int cheung, int gunchook, String doromyung) {
		SqlSession session = factory.openSession();

		av2.setNo(no);
		av2.setSigungu(sigungu);
		av2.setBunji(bunji);
		av2.setDanji(danji);
		av2.setMyunjuk(myunjuk);
		av2.setCheung(cheung);
		av2.setGunchook(gunchook);
		av2.setDoromyung(doromyung);

		int cnt = session.insert("mybatis.apt.insertapt2", av2);
		session.commit();
		session.close();

		return cnt;
	}
	
	@Override
	public int insertJun(int no, String junwol, String gyeyak, int bojeung, int wolse) {
		SqlSession session = factory.openSession();

		jv.setNo(no);
		jv.setJunwol(junwol);
		jv.setGyeyak(gyeyak);
		jv.setBojeung(bojeung);
		jv.setWolse(wolse);

		int cnt1 = session.insert("mybatis.apt.insertjun", jv);
		session.commit();
		session.close();

		return cnt1;
	}

	@Override
	public int insertApt3(int no, String sigungu, String bunji, String danji, double myunjuk,
			int cheung, int gunchook) {
		SqlSession session = factory.openSession();

		av2.setNo(no);
		av2.setSigungu(sigungu);
		av2.setBunji(bunji);
		av2.setDanji(danji);
		av2.setMyunjuk(myunjuk);
		av2.setCheung(cheung);
		av2.setGunchook(gunchook);

		int cnt = session.insert("mybatis.apt.insertapt3", av2);
		session.commit();
		session.close();

		return cnt;
	}

	public List<SimVo> select() {	
		SqlSession session = factory.openSession();
		List<SimVo> list = null;
		try {
			list = session.selectList("mybatis.apt.selectApt");
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return list;
	}
	
}
