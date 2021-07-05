package jungsuk.chapter14_ramdaStream;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Set;
import java.util.function.BiConsumer;

public class Exampla14_4 {

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>();

		for (int i=0; i<10; i++) {
			list.add(i);
		}
		
		//  list의 모든 요소를 출력
		list.forEach(i -> System.out.print(i + ","));
		System.out.println();
		
		list.removeIf(i -> i%2==0 || i%3==0);
		System.out.println(list);
		
		list.replaceAll(i -> i*10);
		System.out.println(list);
		
		
		
	}
}
