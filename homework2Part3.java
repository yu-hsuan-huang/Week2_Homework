import java.io.*;
import java.util.Scanner;

class homework2Part3
{
	public static void main(String[] args)
	{
		int option = 0;
		do{
		System.out.println("主目錄 1)練習一 2)練習二 3)退出 : ");
		Scanner op = new Scanner(System.in);
		option = op.nextInt();
		switch(option)
		{
			case 1:
				Circle[]  c1 = new Circle[20];
				int count = 0;
				System.out.println("使用者連續輸入半徑以產生不同的圓形，接著使用者可以輸入編號與角度，程式便會回傳該圓形對應該角度的弧長與面積。\n");
				while(true)
				{
					System.out.println("請輸入圓的半徑 (輸入\"-1\"跳出) : ");
					Scanner keyin = new Scanner(System.in);
					double in = keyin.nextDouble();
					if(in == -1)
						break;
					else if(in <=0 )
						System.out.println("請輸入大於0的數!\n");
					else
					{
						c1[count] = new Circle(in);
						System.out.println(c1[count].Show());
						count++;
					}
				}
				System.out.println("--------------------------\n");
				for(int i = 0; i < count; i++)
					System.out.println("編號 : " + i + "\t半徑 : " + c1[i].Show());
				while(true)
				{
					System.out.println("選擇編號 (輸入-1回目錄) : ");
					Scanner keyin = new Scanner(System.in);
					int no = keyin.nextInt();
				
					if(no == -1)
						break;
					else if(no < -1 || no >= count)
						System.out.println("編號輸入錯誤!!!\n");
					else
					{
						System.out.println("輸入角度 : ");
						double arg = keyin.nextDouble();
						if(arg<0 || arg>360)
						{
							System.out.println("角度介於0~360度唷!\n");
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
				System.out.println("提供函式可以判斷日期格式是否正確\n");
				while(true)
				{
					System.out.println("請輸入年(西元)/月/日 (以Enter隔開,輸入三次-1離開) : ");
					Scanner keyin = new Scanner(System.in);
					int y = keyin.nextInt();
					int m = keyin.nextInt();
					int d = keyin.nextInt();
					if(y == -1 && m == -1 && d == -1)
						break;
					Date temp = new Date(y,m,d);
					System.out.println("您輸入" + y + "年" + m + "月" + d + "日");
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
		System.out.println("弧長 : " + Arg(a) + "\t面積 : " + Pie(a));
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
			System.out.println("年份請大於0\t");
		else
		{
			System.out.println("年份正確\t");
			
			if(month<1 || month>12)
			{
				System.out.println("月份請介於0至12\t");
			}
			else
			{
				System.out.println("月份正確\t");
				if((year%400 == 0 && month==2) || ( year%4 == 0 && year%100 != 0 && month==2))//閏年判斷
				{
					if(day<0||day>mon[0])
						System.out.println("閏年日期請介於0到" + mon[0]);
					else
						System.out.println("日期正確(閏年)\t");
				}
				else
				{
					if(day<0||day>mon[month])
						System.out.println("日期請介於0到" + mon[month]);
					else
						System.out.println("日期正確\t");
				}
			}
			
		}
		return 1;
	}
}