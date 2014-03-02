import java.io.*;
import java.util.Scanner;

class homework2Part2
{
	public static void main(String[] args)
	{
		int option=1;
		do{
			System.out.println("主目錄 1)練習一 2)練習二 3)練習三 4)練習四 5)退出 : ");
			Scanner op = new Scanner(System.in);
			option = op.nextInt();
			try{
				switch(option)
				{
					case 1:
						System.out.println("轉換西元出生年月日至民國\n請輸入姓名 : ");
						BufferedReader n = new BufferedReader(new InputStreamReader(System.in));
						String name = n.readLine();
						
						System.out.println("請輸入西元出生(以Enter隔開) : ");
						Scanner y = new Scanner(System.in);
						int year = y.nextInt();
						if(year >= 1911)
							year = year - 1911;
						else
						{
							System.out.println("還沒到民國唷~\n");
							break;
						}
						
						Scanner m = new Scanner(System.in);
						int month = m.nextInt();
						if(month < 1 || month > 13)
						{
							System.out.println("月份輸入錯誤~\n");
							break;
						}
						
						Scanner d = new Scanner(System.in);
						int day = d.nextInt();
						if(day > 31 || day < 1)
						{
							System.out.println("日期輸入錯誤~\n");
							break;
						}
						
						System.out.println( name + "您好! \n您的民國生日 : ");
						System.out.println(year + "年" + month + "月" + day + "日");
						break;
					case 2:
						System.out.println("請輸入兩個符點數，再選擇運算子\n");
						System.out.println("數字一 : ");
						Scanner x = new Scanner(System.in);
						double num1 = x.nextDouble();
						System.out.println("數字二 : ");
						Scanner x1 = new Scanner(System.in);
						double num2 = x1.nextDouble();
						int Cul = 0;
						double ans;
						while(Cul != 5)
						{
							System.out.println("1)+ 2)- 3)* 4)/ 5)回主目錄 : ");
							Scanner x3 = new Scanner(System.in);
							Cul = x3.nextInt();
							switch(Cul)
							{
								case 1:
									ans = num1 + num2;
									System.out.println("數字一加數字二 : " + ans + "\n");
									break;
								case 2:
									ans = num1 - num2;
									System.out.println("數字一減數字二 : " + ans + "\n");
									break;
								case 3:
									ans = num1 * num2;
									System.out.println("數字一乘數字二 : " + ans + "\n");
									break;
								case 4:
									if(num2 == 0)
										System.out.println("數字二不可為0!\n");
									else
									{
										ans = num1 / num2;
										System.out.println("數字一除數字二 : " + ans + "\n");
									}
									break;
							}
						}
						break;
					case 3:
						System.out.println("找出您輸入西元年份前的閏年!\n請輸入西元年份 : ");
						Scanner year2 = new Scanner(System.in);
						year = year2.nextInt();
						if(year < 1)
						{
							System.out.println("請輸入大於0的數字!\n");
							break;
						}
						System.out.println("閏年為 : \n");
						for(int i=1 ; i < year ; i++)
						{
							if(i%400 == 0 || ( i%4 == 0 && i%100 != 0))
							{
								System.out.print( i + "\t");
							}
						}
						System.out.print("\n");
						break;
					case 4:
						System.out.println("連續要求使用者輸入資料，包括學生姓名與其成績，輸入完後使用者可以進一步輸入編號來找出對應的學生資料\n");
						Student[] stu = new Student[20];
						int op4=0, count=0;
						do{
							System.out.println("請選擇項目!\n1)輸入學生和成績 2)印出全部成績 3)以編號來查詢學生成績  4)回主目錄 : ");
							Scanner keyin = new Scanner(System.in);
							op4 = keyin.nextInt();
							switch(op4)
							{
								case 1:
									System.out.println("請輸入姓名及成績(以Enter隔開) : ");
									BufferedReader inputName = new BufferedReader(new InputStreamReader(System.in));
									String n1 = inputName.readLine();
									int g1;
									while(true)
									{
										g1 = keyin.nextInt();
										if(g1<0 || g1>100)
											System.out.println("成績請輸入0至100的範圍內!!!\n");
										else
											break;
									}
									stu[count] = new Student(n1,g1);
									count++;
									break;
								case 2:
									for(int i=0; i < count; i++)
										{
											System.out.println("編號 : " + i +"\t");
											stu[i].Show();
										}
									break;
								case 3:
									while(true)
									{
										System.out.println("請輸入編號 (-1退出) : ");
										int con = keyin.nextInt();
										if(con == -1)
											break;
										else if(con<-1 || con >= count)
											System.out.println("標號輸入錯誤!\n");
										else
											stu[con].Show();
									}
									break;
							}
						}while(op4 != 4);
						break;
				}
				}
				catch(IOException e){
				}
		}while(option != 5);
	}
}

class Student{
	private String name;
	private int grade;
	public Student(String n,int g)
	{
		name = n;
		grade = g;
	}
	public void Show()
	{
		System.out.println("姓名 :" + name + "成績 : " + grade );
	}
}
