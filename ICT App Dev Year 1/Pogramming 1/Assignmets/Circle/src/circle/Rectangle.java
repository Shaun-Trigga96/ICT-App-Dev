
package circle;


public class Rectangle {
  
    private double length;
    private double width;

    public Rectangle()
    {
        length = 0;
        width = 0;
    }

    public Rectangle(double l, double w)
    {
        length = l;
        width = w;
    }

    public void set(double l, double w)
    {
        length = l;
        width = w;
    }

    public void print()
    {
        System.out.println("Length = " + length
                  + "; Width = " + width + "\n" +
                  + " Area = " + area() 
                  + "; Perimeter = " + perimeter());
    }

    public double area()
    {
        return length * width;
    }

    public void perimeter()
    {
        return 2 * length + 2 * width;
    }
}