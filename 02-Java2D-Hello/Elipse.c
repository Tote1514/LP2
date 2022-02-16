#include <stdio.h>
typedef struct {
	int x, y;//posição do canto superior de onde vai ser desenhado circulo, não é a posição do centro
	int w, h;//Dimensões do circulo
	int r, g, b; // a cor do circulo
	int rota; // o angulo de rotação do circulo
}Circulo;

void print(Circulo* c){
	printf("A elipse de Dimensões(%d,%d) e posição (%d,%d)",c->w,c->h,c->x,c->y);
}

int main() {
	Circulo c1 = {150,200,50,50,0,0,0,45};
	print(&c1);
	return 0;
}
