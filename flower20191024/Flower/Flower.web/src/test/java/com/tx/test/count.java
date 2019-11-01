package com.tx.test;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class count {
	public static void main(String[] args) {
		File f = new File("D:/software");
		Map<String, Integer> m = null;
		if (f.isDirectory()) {
			look(f, m);
		}
	}

	private static Map<String, Integer> look(File f, Map<String, Integer> m) {
		File[] listFiles = f.listFiles();
		for (File file : listFiles) {
			if (!file.isDirectory()) {
				String name = file.getName();
				int index = name.indexOf(".");
				String s = name.substring(index + 1);
				m = new HashMap<String, Integer>();
				if (m.containsKey(s)) {
					int count = m.get(s);
					m.put(s, count++);
				} else {
					m.put(s, 1);
				}
				System.out.println(file.getAbsolutePath());
			} else {
				look(file, m);
			}
		}
		return m;
	}
}