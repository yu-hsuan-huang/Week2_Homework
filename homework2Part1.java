import java.io.*;
import java.util.Scanner;

class homework2Part1{

	public static void main(String[] args)
	{
		while(true)
		{
			System.out.println("1)�m�ߤ@ 2)�m�ߤG 3)�h�X : ");
			BufferedReader keyin = new BufferedReader( new InputStreamReader(System.in));
			try{
				String temp = keyin.readLine();
				int option = Integer.parseInt(temp);
				if(option == 1)
				{
					System.out.println("4:23:45 �� 13:54:23 ����� : ");
					int sum = Calculate();
					System.out.println("�@ : " + sum + " ��\n");
				}
				else if(option == 2)
				{
					System.out.println("�@�ӼƦr�}�C���Ҧ����Ʀr���`�M�P���� : ");
					int[] data = {54,87,38,31,59,19,88};
					int sum=0;
					double avg=0;
					for(int k : data)
					{
						System.out.println(k+"  ");
						sum += k;
					}
					System.out.println("�`�M�� : "+sum);
					avg=(double)sum/7;
					System.out.println("������ : "+avg);
				}
				if(option == 3)
				{
					break;
				}
			}
			catch(IOException e){
			}
		}
	}
	public static int Calculate()
	{
		return ((13-4)*60+(54-23))*60 +23-45;
	}
	 
}