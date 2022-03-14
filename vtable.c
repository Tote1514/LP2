#include <stdio.h>
#include <stdlib.h>

typedef struct {
    int r,g,b;
} Color;

struct Figure;
typedef void (* Figure_Print) (struct Figure*);
typedef int  (* Figure_Area)  (struct Figure*);
typedef void (*Figure_Max)    (struct Figure*);

typedef struct {
    void (* print) (struct Figure*);
    int  (* area)  (struct Figure*);
    void (*max)  (struct Figure*);
} Figure_vtable;

typedef struct Figure {
    int x, y;
    Color fg, bg;
    Figure_vtable* vtable;
} Figure;

///////////////////////////////////////////////////////////////////////////////

typedef struct {
    Figure super;
    int w, h;
} Rect;

void rect_print (Rect* this) {
    Figure* sup = (Figure*) this;
    printf("Retangulo de tamanho (%d,%d) na posicao (%d,%d) e area %d.\n",
           this->w, this->h, sup->x, sup->y, sup->vtable->area(sup));
    printf("Com cor de fundo: (%d,%d,%d) e cor de contorno: (%d,%d,%d)\n",
           sup->fg.r, sup->fg.g, sup->fg.b, sup->bg.r, sup->bg.g, sup->bg.b);
}

int rect_area (Rect* this) {
    Figure* sup = (Figure*) this;
    return this->w * this->h;
}
//Aumenta 10 de altura e 10 de largura no rectangulo
void rect_max(Rect* this) {
    Figure* sup = (Figure*) this;
    this->w+=10;
    this->h+=10;
}

Figure_vtable rect_vtable = {
    (Figure_Print) rect_print,
    (Figure_Area)  rect_area,
    (Figure_Max)   rect_max
};

Rect* rect_new (int x, int y, int w, int h,int r1, int g1, int b1, int r2, int g2, int b2) {
    Rect*   this  = malloc(sizeof(Rect));
    Figure* sup = (Figure*) this;
    sup->vtable = &rect_vtable;
    sup->x = x;
    sup->y = y;
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
    int w, h;
} Ellipse;

void ellipse_print (Ellipse* this) {
    Figure* sup = (Figure*) this;
    printf("Elipse de tamanho (%d,%d) na posicao (%d,%d) e area %d.\n",
           this->w, this->h, sup->x, sup->y, sup->vtable->area(sup));
    printf("Com cor de fundo: (%d,%d,%d) e cor de contorno: (%d,%d,%d)\n",
        sup->fg.r, sup->fg.g, sup->fg.b, sup->bg.r, sup->bg.g, sup->bg.b);
}

int ellipse_area (Ellipse* this) {
    Figure* sup = (Figure*) this;
    return this->w * this->h;
}
// Aumenta 10 de altura e 10 de largura na elipse
void ellipse_max(Ellipse* this) {
    Figure* sup = (Figure*) this;
    this->w+=10;
    this->h+=10;
}

Figure_vtable ellipse_vtable = {
    (Figure_Print) ellipse_print,
    (Figure_Area)  ellipse_area,
    (Figure_Max) ellipse_max
};

Ellipse* ellipse_new (int x, int y, int w, int h,int r1, int g1, int b1, int r2, int g2, int b2) {
    Ellipse* this = malloc(sizeof(Ellipse));
    Figure* sup = (Figure*) this;
    sup->vtable = &ellipse_vtable;
    sup->x = x;
    sup->y = y;
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

void main (void) {
    Figure* figs[4] = {
        (Figure*) rect_new(10,10,100,100,0,0,0,255,255,255),
        (Figure*) ellipse_new(40,10,140,300,0,0,0,255,255,255),
        (Figure*) rect_new(10,10,100,100,0,0,0,255,255,255),
        (Figure*) ellipse_new(210,110,305,130,0,0,0,255,255,255)
    };

    ///

    for (int i=0; i<4; i++) {
        figs[i]->vtable->print(figs[i]);
        printf("----------------------------------------------------------------------------------\n");
    }
    printf("\n");
    printf("\n");
    ///
    for (int i = 0; i < 4; i++) {
        figs[i]->vtable->max(figs[i]);
    }
    ///
    for (int i=0; i<4; i++) {
        figs[i]->vtable->print(figs[i]);
        printf("----------------------------------------------------------------------------------\n");
    }
    ///

    for (int i=0; i<4; i++) {
        free(figs[i]);
    }
}
