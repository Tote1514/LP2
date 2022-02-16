#include <stdio.h>
typedef struct {
	int x, y;//posição do canto superior de onde vai ser desenhado circulo, não é a posição do centro
	int w, h;//Dimensões do circulo
	int r, g, b; // a cor do circulo
	int rota; // o angulo de rotação do circulo
}Elipse;

void print(Elipse* e){
	printf("A elipse de Dimensões(%d,%d) e posição (%d,%d)",e->w,e->h,e->x,e->y);
}

int main() {
	Elipse elip1 = {150,200,50,50,0,0,0,45};
	print(&elip1);
	return 0;
}
