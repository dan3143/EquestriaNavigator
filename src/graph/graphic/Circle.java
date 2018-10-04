package graph.graphic;

/**
 *
 * @author Daniel
 */
public class Circle {
    public double h;
    public double k;
    public double r;
    
    public Circle(double h, double k, double r){
        this.h = h;
        this.k = k;
        this.r = r;
    }
    
    public boolean contains(double x, double y){
        return pow2(x - h) + pow2(y - k) <= pow2(r);
    }
    
    public boolean insersects(Circle circle){
        double distanceSquared = pow2(h - circle.h) + pow2(k - circle.k);
        return pow2(r - circle.r) <= distanceSquared && distanceSquared <= pow2(r + circle.r);
    }
    
    public static double pow2(double n){
        return n * n;
    }
}
