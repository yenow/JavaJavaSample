package jungsuk.chapter14_ramdaStream;

import org.junit.Test;

public class Example14 {
	
	@Test
	public void 람다식_처음() {
		MyFunction myFunction = () -> {  return "처음입니다"; };
		System.out.println(myFunction.method());
	}
}
