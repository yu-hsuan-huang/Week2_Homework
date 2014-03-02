import java.io.*;
import java.util.Scanner;

class homework2Part4_1{
	public static void main(String[] args)
	{
		int option = 0;
		do{
			System.out.println("1)�m�ߤ@ 2)�m�ߤG 3)�h�X : ");
			Scanner op = new Scanner(System.in);
			option = op.nextInt();
			switch(option)
			{
				case 1:
					System.out.println("��J��ΩάO���Υb�|�ӧ�X�������n\n");
					Circle[] cir = new Circle[20];
					int count=0;
					while(true)
					{
						System.out.println("1)��J��� 2)��J���� 3�h�X(�L�X���G) : ");
						Scanner keyin = new Scanner(System.in);
						int ch = keyin.nextInt();
						if(ch == 3)
							break;
						else if(ch == 1)
						{
							System.out.println("��J��b�| : ");
							double r = keyin.nextDouble();
							cir[count++] = new Circle(r);
						}
						else if(ch == 2)
						{
							System.out.println("��J���b�| (�HEnter�j�}) : ");
							double rad1 = keyin.nextDouble();
							double rad2 = keyin.nextDouble();
							cir[count++] = new Oval(rad1,rad2);
						}
						else
							System.out.println("��J���~!\n");
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
		System.out.println("Circle���n : " + Area());
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
		System.out.println("Oval���n : " + Area());
	}
}