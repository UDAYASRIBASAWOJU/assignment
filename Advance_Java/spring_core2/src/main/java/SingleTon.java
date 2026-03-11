public class SingleTon {
	
	private static SingleTon instance = null;

	private SingleTon() {
		
	}
	
	public static SingleTon get_instance() {
		if (instance == null) {
			instance = new SingleTon();
		}
		
		return instance;
	}
	
	public static void main(String[] args) {
		SingleTon st1 = SingleTon.get_instance();
		SingleTon st2 = SingleTon.get_instance();
		SingleTon st3 = SingleTon.get_instance();
		
		System.out.println(st1);
		System.out.println(st2);
		System.out.println(st3);
	}
}