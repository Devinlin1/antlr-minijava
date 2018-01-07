//测试重名变量错误
class Test{
	int f(int x){
		int y;
	}
	int g(int a){
		int a;
	}
}