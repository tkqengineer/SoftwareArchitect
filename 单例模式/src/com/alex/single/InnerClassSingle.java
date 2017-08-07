package com.alex.single;

public class InnerClassSingle {
	
	private InnerClassSingle() {
	}
	
	private static class Single {
		public static InnerClassSingle single = new InnerClassSingle();
	}
	public static  InnerClassSingle getInstance() {
		return Single.single;
	}
	
	
	public static void main(String[] args) {
		
		System.out.println(InnerClassSingle.getInstance().hashCode());
		System.out.println(InnerClassSingle.getInstance().hashCode());
		
	}
	
	
}
