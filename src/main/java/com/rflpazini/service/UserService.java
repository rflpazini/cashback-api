package com.rflpazini.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.omg.PortableServer.ThreadPolicyOperations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.rflpazini.dao.UserDAO;
import com.rflpazini.model.Users;
import com.rflpazini.utils.Constants;
import com.rflpazini.utils.ConvertJson;

@Service("UserService")
public class UserService {

	@Autowired
	UserDAO uDao;

	@Transactional
	public List<Users> getAllUsers() {
		String json = getUsers();
		transformJson(json);
		return uDao.getAllUsers();
	}

	@Transactional
	public Users getUser(int id) {
		return uDao.getUser(id);
	}

	@Transactional
	public Users getUserByCpf(String cpf) {
		return uDao.getUserByCpf(cpf);
	}

	@Transactional
	public ResponseEntity<String> addUser(Users user) {
		Users userNew = getUserByCpf(user.getUser_cpf());
		if (userNew == null) {
			uDao.addUser(user);
			String json = ConvertJson.convertUser(user);
			return ResponseEntity.ok(json);
		} else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}
	}

	@Transactional
	public void updateUser(Users user) {
		uDao.updateUser(user);
	}

	@Transactional
	public void deleteUser(int id) {
		uDao.deleteUser(id);
	}

	// Get users from URL
	public String getUsers() {
		try {
			URL url = new URL(Constants.USERS_URL);
			HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
			httpURLConnection.setRequestMethod("GET");
			httpURLConnection.connect();

			try {
				BufferedReader bufferedReader = new BufferedReader(
						new InputStreamReader(httpURLConnection.getInputStream()));
				StringBuilder stringBuilder = new StringBuilder();
				String line;
				while ((line = bufferedReader.readLine()) != null) {
					stringBuilder.append(line).append("\n");
				}
				bufferedReader.close();
				return stringBuilder.toString();
			} finally {
				httpURLConnection.disconnect();
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	// Transform json into objects and add new users
	public void transformJson(String json) {
		try {
			JSONArray jsonArray = new JSONArray(json);
			for (int i = 0; i < jsonArray.length(); i++) {
				JSONObject g = jsonArray.getJSONObject(i);
				Users user = new Users();
				user.setUser_cpf(String.valueOf(g.getBigInteger("user_cpf")));
				user.setUser_balance(g.getDouble("balance"));
				user.setUser_name(g.getString("name"));
				this.addUser(user);
			}
		} catch (JSONException e) {
			System.out.println(e.getMessage());
		}
	}

}
