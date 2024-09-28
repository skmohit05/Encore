package com.encore.datapull;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;

import org.apache.commons.lang3.tuple.Pair;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.encore.datapull.model.LTJobDetail;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

public class DBUtil {

	private static final Logger logger = LogManager.getLogger(DBUtil.class);
	private static final String dbUrl = "jdbc:mysql://54.166.121.201:3306/encore_dev";
	private static final String dbUser = "dbuser-ds-1";
	private static final String dbPass = "$Enc120@1";

	public static void upsertLT(final String url, final LTJobDetail jobDetail) throws SQLException, JsonProcessingException {
		String json = JsonUtil.toJson(jobDetail);
		String query = "select 1 from lt_data where url = ?;";
		ResultSet rs = executeSelect(query, new Object[] { url });
		if (rs.next()) {
			String updateQuery = "update lt_data set content = ? where url = ?";
			int rowsAffected = executeQuery(updateQuery, new Object[] { json, url });
			logger.info("update rows affected : " + rowsAffected);
		} else {
			String insertQuery = "insert into lt_data (url, content) values (? , ?)";
			int rowsAffected = executeQuery(insertQuery, new Object[] { url, json });
			logger.info("insert rows affected : " + rowsAffected);
		}
	}

	public static LTJobDetail getLTJobDetail(final String url) throws SQLException, JsonMappingException, JsonProcessingException {
		String query = "select content from lt_data where url = ?";
		ResultSet rs = executeSelect(query, new Object[] { url });
		LTJobDetail jobDetail = null;
		if (rs.next()) {
			String json = rs.getString(1);
			jobDetail = JsonUtil.fromJson(json, LTJobDetail.class);
		}
		return jobDetail;
	}


	public static List<Pair<String, LTJobDetail>> getAllLTJobDetails() throws SQLException, JsonMappingException, JsonProcessingException {
		String query = "select url, content from lt_data";
		ResultSet rs = executeSelect(query, new Object[0]);
		List<Pair<String, LTJobDetail>> jobDetails = new ArrayList<>();
		while (rs.next()) {
			String url = rs.getString(1);
			String json = rs.getString(2);
			LTJobDetail jobDetail = JsonUtil.fromJson(json, LTJobDetail.class);
			jobDetails.add(Pair.of(url, jobDetail));
		}
		return jobDetails;
	}

	private static ResultSet executeSelect(final String query, final Object[] params) throws SQLException {
		try (Connection conn = DriverManager.getConnection(dbUrl, dbUser, dbPass)) {
			PreparedStatement stmt = conn.prepareStatement(query);
			for (int i = 0; i < params.length; i++) {
				stmt.setString(i + 1, (String) params[i]);
			}
			ResultSet rs = stmt.executeQuery();
			CachedRowSet crs = RowSetProvider.newFactory().createCachedRowSet();
			crs.populate(rs);
			rs.close();
			stmt.close();
			return crs;
		}
	}

	private static int executeQuery(final String query, final Object[] params) throws SQLException {
		try (Connection conn = DriverManager.getConnection(dbUrl, dbUser, dbPass)) {
			PreparedStatement stmt = conn.prepareStatement(query);
			for (int i = 0; i < params.length; i++) {
				stmt.setString(i + 1, (String) params[i]);
			}
			int count = stmt.executeUpdate();
			stmt.close();
			return count;
		}
	}
}
