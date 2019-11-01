package com.tedu.sp02;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@SpringBootTest
class Sp02ItemserviceApplicationTests {

	@Test
	void contextLoads() {
				long sum=1;
				long pre=0;
				long now=1;
				ArrayList arrayList = new ArrayList(100);
				arrayList.add(sum);
				for (int i = 0 ; i <99;i++) {
					sum=now+pre;
					pre=now;
					now=sum;
					arrayList.add(sum);
			}
			System.out.println(arrayList.toString());
			System.out.println(arrayList.size());
			}
	@Test
	public void findAllFiles() {
		Map<String,Object> map=new HashMap<>();
		LinkedList l = new LinkedList();
		File f = new File("D:/software");
		if (f.isDirectory()) {
			l= look(f,l);
		}
		System.err.println(l.toString());
		System.err.println(l.size());
		
	}
	public LinkedList look(File f,LinkedList l) {
		File[] listFiles = f.listFiles();
		for (File file : listFiles) {
			if (!file.isDirectory()) {
				l.add(file.getName());
			}else {
				l=look(file,l);
			}					
		}
		return l;	
	}
		}


