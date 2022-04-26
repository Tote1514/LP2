#include <stdio.h>
#include <stdlib.h>

typedef struct {
    int x, y;
    int w, h;
} Rect;
Rect* rect_new () {
    Rect*  this  = malloc(sizeof(Rect));
    this->x = 0;
    this->y = 0;
    this->w = 10;
    this->h = 20;
}

void rect_print (Rect* this) {

    printf("Retangulo de tamanho (%d,%d) na posicao (%d,%d).\n",this->w, this->h, this->x, this->y);
}
void rect_drag(Rect* this, int dx, int dy){
    this->x += dx;
    this->y += dy;
}
