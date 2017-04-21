class T{
	private T(){}
	final static T t = new T();
	public static T getInstance(){
		return t;
	}
}

class A{
	public static void main(String[] args) {
		T a = T.getInstance();
		assert a == T.getInstance();

	}
}