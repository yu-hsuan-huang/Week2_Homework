import java.io.*;
import java.util.Scanner;

class homework2Part2
{
	public static void main(String[] args)
	{
		int option=1;
		do{
			System.out.println("�D�ؿ� 1)�m�ߤ@ 2)�m�ߤG 3)�m�ߤT 4)�m�ߥ| 5)�h�X : ");
			Scanner op = new Scanner(System.in);
			option = op.nextInt();
			try{
				switch(option)
				{
					case 1:
						System.out.println("�ഫ�褸�X�ͦ~���ܥ���\n�п�J�m�W : ");
						BufferedReader n = new BufferedReader(new InputStreamReader(System.in));
						String name = n.readLine();
						
						System.out.println("�п�J�褸�X��(�HEnter�j�}) : ");
						Scanner y = new Scanner(System.in);
						int year = y.nextInt();
						if(year >= 1911)
							year = year - 1911;
						else
						{
							System.out.println("�٨S������~\n");
							break;
						}
						
						Scanner m = new Scanner(System.in);
						int month = m.nextInt();
						if(month < 1 || month > 13)
						{
							System.out.println("�����J���~~\n");
							break;
						}
						
						Scanner d = new Scanner(System.in);
						int day = d.nextInt();
						if(day > 31 || day < 1)
						{
							System.out.println("�����J���~~\n");
							break;
						}
						
						System.out.println( name + "�z�n! \n�z������ͤ� : ");
						System.out.println(year + "�~" + month + "��" + day + "��");
						break;
					case 2:
						System.out.println("�п�J��Ӳ��I�ơA�A��ܹB��l\n");
						System.out.println("�Ʀr�@ : ");
						Scanner x = new Scanner(System.in);
						double num1 = x.nextDouble();
						System.out.println("�Ʀr�G : ");
						Scanner x1 = new Scanner(System.in);
						double num2 = x1.nextDouble();
						int Cul = 0;
						double ans;
						while(Cul != 5)
						{
							System.out.println("1)+ 2)- 3)* 4)/ 5)�^�D�ؿ� : ");
							Scanner x3 = new Scanner(System.in);
							Cul = x3.nextInt();
							switch(Cul)
							{
								case 1:
									ans = num1 + num2;
									System.out.println("�Ʀr�@�[�Ʀr�G : " + ans + "\n");
									break;
								case 2:
									ans = num1 - num2;
									System.out.println("�Ʀr�@��Ʀr�G : " + ans + "\n");
									break;
								case 3:
									ans = num1 * num2;
									System.out.println("�Ʀr�@���Ʀr�G : " + ans + "\n");
									break;
								case 4:
									if(num2 == 0)
										System.out.println("�Ʀr�G���i��0!\n");
									else
									{
										ans = num1 / num2;
										System.out.println("�Ʀr�@���Ʀr�G : " + ans + "\n");
									}
									break;
							}
						}
						break;
					case 3:
						System.out.println("��X�z��J�褸�~���e���|�~!\n�п�J�褸�~�� : ");
						Scanner year2 = new Scanner(System.in);
						year = year2.nextInt();
						if(year < 1)
						{
							System.out.println("�п�J�j��0���Ʀr!\n");
							break;
						}
						System.out.println("�|�~�� : \n");
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
						System.out.println("�s��n�D�ϥΪ̿�J��ơA�]�A�ǥͩm�W�P�䦨�Z�A��J����ϥΪ̥i�H�i�@�B��J�s���ӧ�X�������ǥ͸��\n");
						Student[] stu = new Student[20];
						int op4=0, count=0;
						do{
							System.out.println("�п�ܶ���!\n1)��J�ǥͩM���Z 2)�L�X�������Z 3)�H�s���Ӭd�߾ǥͦ��Z  4)�^�D�ؿ� : ");
							Scanner keyin = new Scanner(System.in);
							op4 = keyin.nextInt();
							switch(op4)
							{
								case 1:
									System.out.println("�п�J�m�W�Φ��Z(�HEnter�j�}) : ");
									BufferedReader inputName = new BufferedReader(new InputStreamReader(System.in));
									String n1 = inputName.readLine();
									int g1;
									while(true)
									{
										g1 = keyin.nextInt();
										if(g1<0 || g1>100)
											System.out.println("���Z�п�J0��100���d��!!!\n");
										else
											break;
									}
									stu[count] = new Student(n1,g1);
									count++;
									break;
								case 2:
									for(int i=0; i < count; i++)
										{
											System.out.println("�s�� : " + i +"\t");
											stu[i].Show();
										}
									break;
								case 3:
									while(true)
									{
										System.out.println("�п�J�s�� (-1�h�X) : ");
										int con = keyin.nextInt();
										if(con == -1)
											break;
										else if(con<-1 || con >= count)
											System.out.println("�и���J���~!\n");
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
		System.out.println("�m�W :" + name + "���Z : " + grade );
	}
}
