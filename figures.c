#include <stdio.h>
#include <stdlib.h>

typedef struct {
    int r,g,b;
} Color;

struct Figure;
typedef void (* Figure_Print) (struct Figure*);

typedef struct Figure {
    Color fg, bg;
    void (* print) (struct Figure*);
} Figure;

///////////////////////////////////////////////////////////////////////////////

typedef struct {
    Figure super;
    int x, y;
    int w, h;
} Rect;

void rect_print (Rect* this) {
    Figure* sup = (Figure*) this;
    printf("Retangulo de tamanho (%d,%d) na posicao (%d,%d).\n",
           this->w, this->h, this->x, this->y);
    printf("Com cor de fundo: (%d,%d,%d) e cor de contorno: (%d,%d,%d)\n",
            sup->fg.r, sup->fg.g, sup->fg.b, sup->bg.r, sup->bg.g, sup->bg.b);
}

Rect* rect_new (int x, int y, int w, int h,int r1, int g1, int b1, int r2, int g2, int b2) {
    Rect*   this  = malloc(sizeof(Rect));
    Figure* sup = (Figure*) this;
    sup->print = (Figure_Print) rect_print;
    this->x = x;
    this->y = y;
    this->w = w;
    this->h = h;
    sup->fg.r = r1;
    sup->fg.g = g1;
    sup->fg.b = b1;
    sup->fg.r = r2;
    sup->fg.g = g2;
    sup->fg.b = b2;
}

///////////////////////////////////////////////////////////////////////////////

typedef struct {
    Figure super;
    int x, y;
    int w, h;
} Ellipse;

void Ellipse_print (Ellipse* this) {
    Figure* sup = (Figure*) this;
    printf("Elipse de tamanho (%d,%d) na posicao (%d,%d).\n",
           this->w, this->h, this->x, this->y);
    printf("Com cor de fundo: (%d,%d,%d) e cor de contorno: (%d,%d,%d)\n",
         sup->fg.r, sup->fg.g, sup->fg.b, sup->bg.r, sup->bg.g, sup->bg.b);
}

Ellipse* ellipse_new (int x, int y, int w, int h,int r1, int g1, int b1, int r2, int g2, int b2) {
    Ellipse* this = malloc(sizeof(Ellipse));
    Figure* sup = (Figure*) this;
    sup->print = (Figure_Print) Ellipse_print;
    this->x = x;
    this->y = y;
    this->w = w;
    this->h = h;
    sup->fg.r = r1;
    sup->fg.g = g1;
    sup->fg.b = b1;
    sup->fg.r = r2;
    sup->fg.g = g2;
    sup->fg.b = b2;
}
///////////////////////////////////////////////////////////////////////////////

typedef struct Triangle{
    Figure super;
    int x[3];
    int y[3];
}Triangle;

void triangle_print(Triangle* this) {
    Figure* sup = (Figure*) this;
    printf("Triângulo com os vertices nas posições:(%d,%d),(%d,%d),(%d,%d)\n",
           this->x[0], this->y[0], this->x[1], this->y[1], this->x[2], this->y[2]);
    printf("Com cor de fundo: (%d,%d,%d) e cor de contorno: (%d,%d,%d)\n",
        sup->fg.r, sup->fg.g, sup->fg.b, sup->bg.r, sup->bg.g, sup->bg.b);
}

Triangle* triangle_new (int x1, int x2, int x3, int y1, int y2, int y3,int r1, int g1, int b1, int r2, int g2, int b2) {
    Triangle* this = malloc(sizeof(Triangle));
    Figure* sup = (Figure*) this;
    sup->print = (Figure_Print) triangle_print;
    this->x[0] = x1;
    this->x[1] = x2;
    this->x[2] = x3;
    this->y[0] = y1;
    this->y[1] = y2;
    this->y[2] = y3;
    sup->fg.r = r1;
    sup->fg.g = g1;
    sup->fg.b = b1;
    sup->fg.r = r2;
    sup->fg.g = g2;
    sup->fg.b = b2;
}
///////////////////////////////////////////////////////////////////////////////

void main (void) {
    Figure* figs[6] = {
        (Figure*) rect_new(10,10,100,100,0,0,0,255,255,255),
        (Figure*) ellipse_new(40,10,140,300,0,0,0,255,255,255),
        (Figure*) rect_new(10,10,100,100,0,0,0,255,255,255),
        (Figure*) ellipse_new(210,110,305,130,0,0,0,255,255,255),
        (Figure*) triangle_new(45,35,45,69,56,78,0,0,0,255,255,255),
        (Figure*) triangle_new(57,89,78,45,34,32,0,0,0,255,255,255)
    };

    ///

    for (int i=0; i<6; i++) {
        figs[i]->print(figs[i]);
    }

    ///

    for (int i=0; i<6; i++) {
        free(figs[i]);
    }
}
