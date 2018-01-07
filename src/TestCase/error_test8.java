//测试算术表达式的类型错误
class Test{
	void f(int y){
		int x;
		x=2+3; //正确
		x=2+true;  //错误
		return;
	}
}