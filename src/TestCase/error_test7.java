//测试算术表达式的类型错误
class Test{
	void f(int x){
		int x;
		int[] y;
		x=y[2];
		x=x[2];
		return;
	}
}