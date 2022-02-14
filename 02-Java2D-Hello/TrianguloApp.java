public class TrianguloApp{
	public static void main(String[] args){
		Triangulo t1 = new Triangulo(100,120,150,280,170,200,0,0,0);
		t1.print();
	}
}
class Triangulo{
	int x1, y1;//Coordenadas do primeiro vertice
	int x2, y2;// Coordenadas do segundo vertice
	int x3, y3;// Coorenadas do terceiro vertice
	int r, g, b;// Cores do triângulo
	Triangulo(int x1, int x2, int x3, int y1, int y2, int y3, int r, int g, int b){
		this.x1 = x1;
		this.x2 = x2;
		this.x3 = x3;
		this.y1 = y1;
		this.y2 = y2;
		this.y3 = y3;
		this.r = r;
		this.g =g;
		this.b = b;
	}
	void print(){
		System.out.format("O Triângulo com os vertices nas posições:\n(%d,%d)\n(%d,%d)\n(%d,%d)",
				this.x1,this.y1,this.x2,this.y2,this.x3, this.y3);


	}
}
