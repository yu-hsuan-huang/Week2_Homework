import java.io.*;
import java.util.Scanner;

class homework2Part3
{
	public static void main(String[] args)
	{
		int option = 0;
		do{
		System.out.println("�D�ؿ� 1)�m�ߤ@ 2)�m�ߤG 3)�h�X : ");
		Scanner op = new Scanner(System.in);
		option = op.nextInt();
		switch(option)
		{
			case 1:
				Circle[]  c1 = new Circle[20];
				int count = 0;
				System.out.println("�ϥΪ̳s���J�b�|�H���ͤ��P����ΡA���ۨϥΪ̥i�H��J�s���P���סA�{���K�|�^�ǸӶ�ι����Ө��ת������P���n�C\n");
				while(true)
				{
					System.out.println("�п�J�ꪺ�b�| (��J\"-1\"���X) : ");
					Scanner keyin = new Scanner(System.in);
					double in = keyin.nextDouble();
					if(in == -1)
						break;
					else if(in <=0 )
						System.out.println("�п�J�j��0����!\n");
					else
					{
						c1[count] = new Circle(in);
						System.out.println(c1[count].Show());
						count++;
					}
				}
				System.out.println("--------------------------\n");
				for(int i = 0; i < count; i++)
					System.out.println("�s�� : " + i + "\t�b�| : " + c1[i].Show());
				while(true)
				{
					System.out.println("��ܽs�� (��J-1�^�ؿ�) : ");
					Scanner keyin = new Scanner(System.in);
					int no = keyin.nextInt();
				
					if(no == -1)
						break;
					else if(no < -1 || no >= count)
						System.out.println("�s����J���~!!!\n");
					else
					{
						System.out.println("��J���� : ");
						double arg = keyin.nextDouble();
						if(arg<0 || arg>360)
						{
							System.out.println("���פ���0~360�׭�!\n");
							continue;
						}
						else
						{
							c1[no].Print(arg);
						}
					}
				}
				break;
			case 2:
				System.out.println("���Ѩ禡�i�H�P�_����榡�O�_���T\n");
				while(true)
				{
					System.out.println("�п�J�~(�褸)/��/�� (�HEnter�j�},��J�T��-1���}) : ");
					Scanner keyin = new Scanner(System.in);
					int y = keyin.nextInt();
					int m = keyin.nextInt();
					int d = keyin.nextInt();
					if(y == -1 && m == -1 && d == -1)
						break;
					Date temp = new Date(y,m,d);
					System.out.println("�z��J" + y + "�~" + m + "��" + d + "��");
					temp.Judge();
				}
				break;
		}
		}while(option != 3);
	}
}
class Circle
{
	private double r = 0;
	
	double Show()
	{
		return r;
	}
	
	public Circle(double x)
	{
		r = x;
	}
	
	double Arg(double a)
	{
		return Math.PI * r * r * (a/360);
	}
	
	double Pie(double a)
	{
		return Math.PI * r * (a/360);
	}
	
	void Print(double a)
	{
		System.out.println("���� : " + Arg(a) + "\t���n : " + Pie(a));
	}
}

class Date{
	private int year,month,day;
	
	public Date(int y,int m,int d)
	{
		year = y;
		month = m;
		day = d;
	}
	int Judge()
	{
		int[] mon={29,31,28,31,30,31,30,31,31,30,31,30,31};
		if(year < 0)
			System.out.println("�~���Фj��0\t");
		else
		{
			System.out.println("�~�����T\t");
			
			if(month<1 || month>12)
			{
				System.out.println("����Ф���0��12\t");
			}
			else
			{
				System.out.println("������T\t");
				if((year%400 == 0 && month==2) || ( year%4 == 0 && year%100 != 0 && month==2))//�|�~�P�_
				{
					if(day<0||day>mon[0])
						System.out.println("�|�~����Ф���0��" + mon[0]);
					else
						System.out.println("������T(�|�~)\t");
				}
				else
				{
					if(day<0||day>mon[month])
						System.out.println("����Ф���0��" + mon[month]);
					else
						System.out.println("������T\t");
				}
			}
			
		}
		return 1;
	}
}