package day10;

public class Data {
	int x,y;
	int cnt;
	public Data(int x, int y, int cnt) {
		this.x = x;
		this.y = y;
		this.cnt = cnt;
	}
	@Override
	public String toString() { //디버깅용
		return "Data [x=" + x + ", y=" + y + ", cnt=" + cnt + "]";
	}
	

}
