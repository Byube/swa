package com.dnk.swa.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.dnk.swa.dto.ListenAgoDto;
import com.dnk.swa.dto.SwaLogDto;
import com.dnk.swa.dto.SwaLoginDto;
import com.dnk.swa.dto.SwaMemDto;
import com.dnk.swa.dto.SwaMstDto;

@Repository
public class SttDao {

private static final String NAME_SPACE = "com.dnk.swa.dao.SttDao";
	
	@Autowired
	@Qualifier(value = "mariadbsqlSession")
	private SqlSession mariadbsqlSession;
	
	@Autowired
	@Qualifier(value = "postgresqlSession")
	private SqlSession postgresqlSession;
	
	public List<SwaLoginDto> gettest(){
		return mariadbsqlSession.selectList(NAME_SPACE + ".gettest");
	}
	
	public void insertLog(SwaLogDto log) {
		mariadbsqlSession.insert(NAME_SPACE + ".insertLog", log);
	}
	
	public List<SwaLoginDto> getMember(SwaLoginDto sld) {
		return mariadbsqlSession.selectList(NAME_SPACE + ".getMember", sld);
	};
	public String checkLogin(SwaLoginDto sld) {
		return mariadbsqlSession.selectOne(NAME_SPACE + ".checkLogin",sld);
	};
	public List<SwaLogDto> getLogtable(SwaLogDto sld){
		return mariadbsqlSession.selectList(NAME_SPACE + ".getLogtable",sld);
	};
	public int getLogCount(SwaLogDto sld) {
		return mariadbsqlSession.selectOne(NAME_SPACE + ".getLogCount",sld);
	};
	public String getUserId(SwaLoginDto sld) {
		return mariadbsqlSession.selectOne(NAME_SPACE + ".getUserId",sld);
	};
	public List<SwaLoginDto> getUser(SwaLoginDto sld){
		return mariadbsqlSession.selectList(NAME_SPACE + ".getUser",sld);
	};
	
	public void insertUser(SwaLoginDto sld) {
		mariadbsqlSession.insert(NAME_SPACE + ".insertUser", sld);
	};
	public void levelChange(SwaLoginDto sld) {
		mariadbsqlSession.insert(NAME_SPACE + ".levelChange", sld);
	};
	public void deleteUser(SwaLoginDto sld) {
		mariadbsqlSession.delete(NAME_SPACE + ".deleteUser", sld);
	};
	public void resetPw(SwaLoginDto sld) {
		mariadbsqlSession.update(NAME_SPACE + ".resetPw",sld);
	};
	public int checkIdok(SwaLoginDto sld) {
		return mariadbsqlSession.selectOne(NAME_SPACE + ".checkIdok" , sld);
	};
	public String getMin() {
		return mariadbsqlSession.selectOne(NAME_SPACE + ".getMin");
	};
	public List<SwaLogDto> getMenu() {
		return mariadbsqlSession.selectList(NAME_SPACE + ".getMenu");
	};
	public int getMstCount(SwaMstDto smd) {
		return mariadbsqlSession.selectOne(NAME_SPACE + ".getMstCount", smd);
	};
	public String getMstMin() {
		return mariadbsqlSession.selectOne(NAME_SPACE + ".getMstMin");
	};
	public List<SwaMstDto> getMstList(SwaMstDto smd){
		return mariadbsqlSession.selectList(NAME_SPACE + ".getMstList", smd);
	};
	public String getMstC(SwaMstDto smd) {
		return mariadbsqlSession.selectOne(NAME_SPACE + ".getMstC", smd);
	};
	public void insertSwaMem(SwaMemDto smd) {
		mariadbsqlSession.insert(NAME_SPACE + ".insertSwaMem", smd);
	};
	public int checksIdok(SwaMemDto smd) {
		return mariadbsqlSession.selectOne(NAME_SPACE + ".checksIdok", smd);
	};
	public int getSwaMemCount(SwaMemDto smd) {
		return mariadbsqlSession.selectOne(NAME_SPACE + ".getSwaMemCount", smd);
	};
	public List<SwaMemDto> getSwaMemList(SwaMemDto smd){
		return mariadbsqlSession.selectList(NAME_SPACE + ".getSwaMemList", smd);
	};
	public String getSwaMemName(SwaMemDto smd) {
		return mariadbsqlSession.selectOne(NAME_SPACE + ".getSwaMemName", smd);
	};
	public void updateSwaMem(SwaMemDto smd) {
		mariadbsqlSession.update(NAME_SPACE + ".updateSwaMem",smd);
	};
	public void deleteSwaMem(SwaMemDto smd) {
		mariadbsqlSession.delete(NAME_SPACE + ".deleteSwaMem",smd);
	};
	
	public String getCenter(SwaLoginDto sld) {	
		return mariadbsqlSession.selectOne(NAME_SPACE + ".getCenter", sld);
	}
	
	public String getMp3Url(ListenAgoDto lad) {
		return postgresqlSession.selectOne(NAME_SPACE + ".getMp3Url", lad);
	}
	
}
