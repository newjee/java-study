package chapter03;

import mypackage.Value;

// 객체로 swap

public class SwapTest03 {
	public static void main(String[] args) {
		Value a = new Value(10);
		Value b = new Value(20);

		System.out.println("a=" + a.val + " b=" + b.val);

		swap(a, b);

		System.out.println("a=" + a.val + " b=" + b.val);
	}

	private static void swap(Value m, Value n) {
		int temp = m.val;
		m.val = n.val;
		n.val = temp;		
	}
//	stack 영역에서 다 소멸됨 => 해결방법 : call by ref

}
