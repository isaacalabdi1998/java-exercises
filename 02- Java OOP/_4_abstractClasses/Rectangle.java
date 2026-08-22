/**
 * Exercise: Abstract Classes - Rectangle
 *
 * Implement a concrete Rectangle class that extends the abstract Shape.
 * You must implement all abstract methods declared in Shape.
 *
 * Key concepts:
 * - Extending an abstract class
 * - Implementing abstract methods
 * - Working with multiple fields
 */
public class Rectangle extends Shape
{
  
    private double width;
    private double height;

  
    public Rectangle(double width, double height)
    {
        if (width <= 0 || height <= 0)
        {
            throw new IllegalArgumentException("Width and height must be greater than 0");
        }
        this.width = width;
        this.height = height;
    }

  
    @Override
    public double area()
    {
        return width * height;
    }

  
    @Override
    public double perimeter()
    {
        return 2 * (width + height);
    }





  
    // --------------- Main Method ---------------
    public static void main(String[] args)
    {
        Rectangle rect = new Rectangle(4.0, 6.0);
      
        System.out.println("Perimeter: " + rect.perimeter());
        rect.describe();
        System.out.println(rect);

    }


}
