package com.frames.springJDBC.example1;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public class DAOImpl implements DAO {
	protected final Log log = LogFactory.getLog(this.getClass());
	private JdbcTemplate jt;

/*	public int getCount(String sql) {
		int count = 0;
		try {
			count = jt.queryForInt(sql);
		} catch (DataAccessException e) {
			log.info("!!!!!!!!!!!!!!!!!!!Exception:" + e);
		}
		return count;
	}*/

	public String getResultValue(String sql, String column) {
		String value = "";
		try {
			SqlRowSet s = jt.queryForRowSet(sql);
			while (s.next()) {
				value = s.getString(column);
			}
		} catch (DataAccessException e) {
			log.info("!!!!!!!!!!!!!!!!!!!Exception:" + e);
		}
		return value;
	}

	public List getResult(String sql) {
		List list = null;
		try {
			list = jt.queryForList(sql);
		} catch (DataAccessException e) {
			log.info("!!!!!!!!!!!!!!!!!!!Exception:" + e);
		}
		return list;
	}

	public void update(String sql) {
		try {
			jt.update(sql);
		} catch (DataAccessException e) {
			log.info("!!!!!!!!!!!!!!!!!!!Exception:" + e);
		}
	}

	public void delete(String sql) {
		try {
			jt.execute(sql);
		} catch (DataAccessException e) {
			log.info("!!!!!!!!!!!!!!!!!!!Exception:" + e);
		}
	}

	public void update(String sql, Object[] params) {
		// TODO Auto-generated method stub
		try {
			jt.update(sql, params);
		} catch (DataAccessException e) {
			log.info("!!!!!!!!!!!!!!!!!!!Exception:" + e);
		}
	}

	public void setJt(JdbcTemplate jt) {
		this.jt = jt;
	}

	public JdbcTemplate getJt() {
		return jt;
	}
}