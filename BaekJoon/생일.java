package 백준문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class 생일 {
	
	static class Person implements Comparable<Person> {
		String name;
		int year;
		int month;
		int day;
		
		public Person(String name,int year,int month,int day) {
			this.name = name; this.year = year; this.month = month; this.day = day;
		}

		@Override
		public int compareTo(Person otherPerson) {
			if(this.year < otherPerson.year)
				return -1;
			else if(this.year > otherPerson.year)
				return 1;
			else {
				if(this.month < otherPerson.month)
					return -1;
				else if(this.month > otherPerson.month)
					return 1;
				else {
					if(this.day < otherPerson.day)
						return -1;
					else if(this.day > otherPerson.day)
						return 1;
					return 0;
				}
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		List<Person> list = new ArrayList<Person>();
		int n = Integer.parseInt(br.readLine());
		
		for(int i = 0;i < n;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String name = st.nextToken();
			int day = Integer.parseInt(st.nextToken());
			int month = Integer.parseInt(st.nextToken());
			int year = Integer.parseInt(st.nextToken());
			
			Person person = new Person(name,year,month,day);
			list.add(person);
		}
		Collections.sort(list);
		Person p1 = list.get(0);
		Person p2 = list.get(list.size() - 1);
		System.out.println(p2.name);
		System.out.println(p1.name);
	}
}
