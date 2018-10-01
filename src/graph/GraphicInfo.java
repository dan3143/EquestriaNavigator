package graph;

import java.awt.Color;
import java.awt.Point;

public class GraphicInfo {
    int h;
    int k;
    int r;
    Color color;
    Color text_color;
    
    public GraphicInfo(int h, int k, int r, Color color, Color text_color){
        this.h = h;
        this.k = k;
        this.r = r;
        this.color = color;
        this.text_color = text_color;
    }
    
    public boolean contains(int x, int y){
        System.out.println("h = " + h);
        System.out.println("k = " + k);
        return pow2(x - h) + pow2(y - k) <= pow2(r);
    }
    
    public boolean insersects(int h0, int k0, int r0){
        int distanceSquared = pow2(h - h0) + pow2(k - k0);
        return pow2(r - r0) <= distanceSquared && distanceSquared <= pow2(r + r0);
    }
    
    public int pow2(int n){
        return n * n;
    }
}