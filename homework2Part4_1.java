import java.io.*;
import java.util.Scanner;

class homework2Part4_1{
	public static void main(String[] args)
	{
		int option = 0;
		do{
			System.out.println("1)練習一 2)練習二 3)退出 : ");
			Scanner op = new Scanner(System.in);
			option = op.nextInt();
			switch(option)
			{
				case 1:
					System.out.println("輸入圓形或是橢圓形半徑來找出它的面積\n");
					Circle[] cir = new Circle[20];
					int count=0;
					while(true)
					{
						System.out.println("1)輸入圓形 2)輸入橢圓形 3退出(印出結果) : ");
						Scanner keyin = new Scanner(System.in);
						int ch = keyin.nextInt();
						if(ch == 3)
							break;
						else if(ch == 1)
						{
							System.out.println("輸入圓半徑 : ");
							double r = keyin.nextDouble();
							cir[count++] = new Circle(r);
						}
						else if(ch == 2)
						{
							System.out.println("輸入橢圓半徑 (以Enter隔開) : ");
							double rad1 = keyin.nextDouble();
							double rad2 = keyin.nextDouble();
							cir[count++] = new Oval(rad1,rad2);
						}
						else
							System.out.println("輸入錯誤!\n");
					}
					for(int i = 0; i < count; i++)
						cir[i].Print();
					break;
				case 2:
					
					break;
			}
		}while(option != 3);
	}
}

class Circle{
	protected double r1;
	
	public Circle(double x)
	{
		r1 = (x>0)?x:0;
	}
	
	public double Area()
	{
		return Math.PI * r1;
	}
	
	public void Print()
	{
		System.out.println("Circle面積 : " + Area());
	}
}

class Oval extends Circle{
	protected double r2;
	
	public Oval(double x2, double x3)
	{
		super(x2);
		r2 = (x3>0)?x3:0;
	}
	public double Area()
	{
		return Math.PI * r1 * r2;
	}
	
	public void Print()
	{
		System.out.println("Oval面積 : " + Area());
	}
}