package org.gradle;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;

public class LogFileReader {

	public static void main(String[] args) {
		LogFileReader l = new LogFileReader();
		l.readLogFile_1();
	}

	public Map<String, Object> readLogFile() {
		String LOG_FILE_URI = "C:\\Users\\ubhagwat\\Documents\\SKYNET\\Ansible\\ansible.d6a18357-de67-49ea-86c9-8b9672fafe28.log";
		String line, json = "";
		try (BufferedReader br = new BufferedReader(new FileReader(LOG_FILE_URI))) {
			while ((line = br.readLine()) != null) {
				if (isLogLineContains(line, "Get Authorization Token for API")) {
					if (!json.isEmpty()) {
						parseJson(json);
						json = "";
					}
				} else {
					json += line;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public Map<String, Object> readLogFile_1() {
		String LOG_FILE_URI = "C:\\Users\\ubhagwat\\Documents\\SKYNET\\Ansible\\ansible.d6a18357-de67-49ea-86c9-8b9672fafe28.log";
		String line, json = "";
		boolean markRead = false;
		boolean startRead = false;
		try (BufferedReader br = new BufferedReader(new FileReader(LOG_FILE_URI))) {
			while ((line = br.readLine()) != null) {
				if (markRead) {
					if (isLogLineEquals(line, "\"json\": {")) {
						startRead = true;
					}
				}
				if (startRead) {
					json += line;
					if (isLogLineEquals(line, "},")) {
						startRead = false;
						markRead = false;
						break;
					}
				}
				if (isLogLineContains(line, "insert tenant service resource stack cloudformation component")) {
					markRead = true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (json != null && json != "") {
			json = json.trim();
			json = json.substring(json.indexOf('{'), json.lastIndexOf('}') + 1);
		}
		try {
		parseJson(json);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean isLogLineContains(String line, String text) {
		return line.contains(text);
	}

	public boolean isLogLineEquals(String line, String text) {
		if (line != "" && line != null) {
			line = line.trim();
		}
		return line.equals(text);
	}

	public void parseJson(String json) throws Exception {
		System.out.println(json);
		if (!json.startsWith("{") && !json.endsWith("}"))
			json = "{" + json + "}";
		ObjectMapper om = new ObjectMapper();
		System.out.println(om.readValue(json, Map.class));
		Map<?, ?> myJSONMap = om.readValue(json, Map.class);
		System.out.println(myJSONMap.get("ApplicationName"));
	}

}
