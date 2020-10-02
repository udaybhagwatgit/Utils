package org.gradle;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.codehaus.plexus.util.StringUtils;

import com.fasterxml.jackson.databind.ObjectMapper;

public class SecondApproach {

	public static void main(String[] args) {
		SecondApproach ss = new SecondApproach();

		String LOG_FILE_URI = "C:\\Users\\ubhagwat\\Documents\\SKYNET\\Ansible\\ansible.d6a18357-de67-49ea-86c9-8b9672fafe28.log";
		FileReader fr = null;
		String taskToExtract = "Log Batch ELB Security Group Component";
		try {
			fr = new FileReader(new File(LOG_FILE_URI));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BufferedReader reader = new BufferedReader(fr);
		ss.scanFile(taskToExtract, reader, LOG_FILE_URI);
	}

	public void scanFile(String taskToExtract, BufferedReader reader, String logFileUri) {

		List<String> allFullLines = new ArrayList<>();
		List<String> allTrimmedLines = new ArrayList<>();
		Map<String, Integer> lineFrequencyMap = new HashMap<>();
		List<String> linesToProcess = new ArrayList<>();

		List<Map<?, ?>> jsonMapList = new ArrayList<>();
		try {
			reader.lines().filter(s -> s.contains(taskToExtract)).forEach(linel -> allFullLines.add(linel));
			for (String eachFullLine : allFullLines) {
				String eachTrimmedLine = eachFullLine
						.substring(eachFullLine.indexOf('|') + 1, eachFullLine.lastIndexOf(']') + 1).trim();
				allTrimmedLines.add(eachTrimmedLine);
			}

			for (String eachTrimmedLine : allTrimmedLines) {
				if (!lineFrequencyMap.containsKey(eachTrimmedLine)) {
					lineFrequencyMap.put(eachTrimmedLine, Collections.frequency(allTrimmedLines, eachTrimmedLine));
				}
			}

			// In the allFullLines list, get the appropriate line as per above map
			for (String eachTrimmedLine : lineFrequencyMap.keySet()) {
				int count = 0;
				for (String eachFullLine : allFullLines) {
					if (eachFullLine.contains(eachTrimmedLine)) {
						count++;
					}
					if (count == lineFrequencyMap.get(eachTrimmedLine)) {
						linesToProcess.add(eachFullLine);
						break;
					}
				}
			}

			for (String eachLinetoProcess : linesToProcess) {
				Map<?, ?> jsonMap = readLogFile_1(eachLinetoProcess, logFileUri);
				jsonMapList.add(jsonMap);
			}

			for (Map<?, ?> eachjsonMap : jsonMapList) {
				System.out.println(eachjsonMap);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Map<?, ?> readLogFile_1(String lineToProcess, String logFileUri) {
		String line, json = "";
		boolean markRead = false;
		boolean startRead = false;
		Map<?, ?> jsonMap = null;
		try (BufferedReader br = new BufferedReader(new FileReader(logFileUri))) {
			while ((line = br.readLine()) != null) {

				if (markRead) {
					if ((isLogLineContains(line, "TASK") && !line.equals(lineToProcess)) || (isLogLineContains(line, "META: ran handlers"))) {
						break;
					}
					//For ---> changed: [localhost], fatal: [localhost], skipping: [localhost] - Need to understand what should be be done 
					if (isLogLineContains(line, "ok: [localhost] => {")) {
						startRead = true;
					}
				}
				if (startRead) {
					if ((isLogLineContains(line, "TASK") && !line.equals(lineToProcess)) || (isLogLineContains(line, "META: ran handlers"))) {
						break;
					}
					json += line;
					if ((isLogLineContains(line, "TASK") && !line.equals(lineToProcess)) || (isLogLineContains(line, "META: ran handlers"))) {
						break;
					}
				}
				if (isLogLineEquals(line, lineToProcess)) {
					markRead = true;
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (json != null && json != "") {
			json = json.trim();
			json = json.substring(json.indexOf('{'));
			try {
				jsonMap = parseJson(json);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			jsonMap = new HashMap<String, String>();
		}

		return jsonMap;
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

	public Map<?, ?> parseJson(String json) throws Exception {
		if (!json.startsWith("{") && !json.endsWith("}")) {
			json = "{" + json + "}";
		} else if (!json.endsWith("}")) {
			json = json + "}";
		} else if (!json.startsWith("{")) {
			json = "{" + json;
		}
		ObjectMapper om = new ObjectMapper();
		Map<?, ?> myJSONMap = om.readValue(json, Map.class);
		return myJSONMap;
	}

	/*
	 * public void scanAgain() { String LOG_FILE_URI =
	 * "C:\\Users\\ubhagwat\\Documents\\SKYNET\\Ansible\\ansible.d6a18357-de67-49ea-86c9-8b9672fafe28.log";
	 * 
	 * try { FileReader fr = new FileReader(new File(LOG_FILE_URI)); BufferedReader
	 * reader = new BufferedReader(fr); reader.lines().forEach(line -> {
	 * 
	 * if (line.contains("get authorization token for API")) { System.out.println();
	 * }
	 * 
	 * });
	 * 
	 * } catch (Exception e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); }
	 * 
	 * }
	 */
}
