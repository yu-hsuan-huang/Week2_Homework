import java.io.*;
import java.util.Scanner;

class homework2Part4_2{
	public static void main(String[] args)
	{
		Shape[] shapes = new Shape[50];
		int option = 0, count = 0;
		do{
			System.out.println("1)三角形 2)矩形 3)圓形 4)橢圓形 5)印出 6)退出");
			Scanner op = new Scanner(System.in);
			option = op.nextInt();
			switch(option)
			{
				case 1:
					System.out.println("請輸入底 : ");
					double d = op.nextDouble();
					System.out.println("請輸入高 : ");
					double h = op.nextDouble();
					shapes[count++] = new Triangle(d,h);
					break;
				case 2:
					System.out.println("請輸入長 : ");
					double d1 = op.nextDouble();
					System.out.println("請輸入寬 : ");
					double h1 = op.nextDouble();
					shapes[count++] = new Rectangle(d1,h1);
					break;
				case 3:
					System.out.println("請輸入半徑 : ");
					double r = op.nextDouble();
					shapes[count++] = new Circle(r);
					break;
				case 4:
					System.out.println("請輸入半徑一 : ");
					double r1 = op.nextDouble();
					System.out.println("請輸入半徑二 : ");
					double r2 = op.nextDouble();
					shapes[count++] = new Oval(r1,r2);
					break;
				case 5:
					for(int i=0; i < count; i++)
					{
						shapes[i].show();
					}
					break;
			}
		}while(option != 6);
	}
}

abstract class Shape
{
	abstract void show();
}
class Triangle extends Shape//三角
{
	private double d,h;
	public Triangle(double a,double b)
	{
		d = (a>0)? a:0;
		h = (b>0)? b:0;
	}
	public void show()
	{
		System.out.println("(三角形)面積 : " + (d*h / 2));
	}
}
class Rectangle extends Shape//矩形
{	
	private double d,h;
	public Rectangle(double a,double b)
	{
		d = (a>0)? a:0;
		h = (b>0)? b:0;
	}
	public void show()
	{
		System.out.println("(長方形)面積 : " + (d * h));
	}
}
class Circle extends Shape//圓
{
	private double rad;
	public Circle(double r)
	{
		rad = (r>0)? r:0;
	}
	public void show()
	{
		System.out.println("(圓形)面積 : " + (3.14 * rad * rad));
	}
}
class Oval extends Shape//橢圓
{
	private double rad1,rad2;
	public Oval(double r1,double r2)
	{
		rad1 = (r1>0)? r1:0;
		rad2 = (r2>0)? r2:0;
	}
	public void show()
	{
		System.out.println("(橢圓形)面積 : " + (3.14 * rad1 * rad2));
	}
}
