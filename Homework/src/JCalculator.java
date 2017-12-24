import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.lang.Math;
public class JCalculator extends JFrame implements ActionListener 
{
	private JTextField text;
	private JButton[] b=new JButton[23];
	double sum;
	calculate c=new calculate();
	public JCalculator()
	{
		super("标准计算器");
		this.setBounds(700,300,500,400);
		//this.setResizable(false);  //设置窗口大小是否可以改变
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		GridBagLayout gbl = new GridBagLayout();  //采用网格包布局
		this.setLayout(gbl); 
		GridBagConstraints gbs = new GridBagConstraints();  
		gbs.fill=GridBagConstraints.BOTH;
		gbs.insets = new Insets(7, 7, 5, 5);
		gbs.gridwidth = GridBagConstraints.REMAINDER;
		gbs.gridheight=1;
		gbs.weightx=1;
		gbs.weighty=1;
		text=new JTextField("0");
		gbl.setConstraints(text, gbs);
		text.setHorizontalAlignment(JTextField.RIGHT);
		text.setFont(new java.awt.Font("黑体", 5, 25));
		text.setEditable(false);
		this.add(text);//添加文本框
		b[0]=new JButton("  ←  ");
		b[1]=new JButton("全清");
		b[2]=new JButton("清屏");
		b[3]=new JButton("+/-");
		b[4]=new JButton("1/x");
		b[5]=new JButton("7");
		b[6]=new JButton("8");
		b[7]=new JButton("9");
		b[8]=new JButton("÷");
		b[9]=new JButton("x*x");
		b[10]=new JButton("4");
		b[11]=new JButton("5");
		b[12]=new JButton("6");
		b[13]=new JButton("X");
		b[14]=new JButton("√");
		b[15]=new JButton("1");
		b[16]=new JButton("2");
		b[17]=new JButton("3");
		b[18]=new JButton("-");
		b[19]=new JButton("=");
		b[20]=new JButton("0");
		b[21]=new JButton(".");
		b[22]=new JButton("+");
		for(int i=0; i<23; i++)
		{
			if(i==4||i==9||i==14)
				Set(b[i],0,1,1,1,0,0,gbs,gbl,1);
			else if(i==5||i==6||i==7||i==10||i==11||i==12||i==15||i==16||i==17)
				Set(b[i],2,1,1,1,0,0,gbs,gbl,0);
			else if(i==19)
				Set(b[i],2,2,1,1,0,0,gbs,gbl,1);
			else if(i==20)
				Set(b[i],4,1,1,1,1,5,gbs,gbl,0);
			else if(i==21)
				Set(b[i],2,1,1,1,5,5,gbs,gbl,0);
			else if(i==22)
				Set(b[i],2,1,1,1,7,5,gbs,gbl,1);
			else
				Set(b[i],2,1,1,1,0,0,gbs,gbl,1);
		}
		this.setVisible(true);
	}
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getActionCommand().equals("1"))
			Add(1);
		else if(e.getActionCommand().equals("2"))
			Add(2);
		else if(e.getActionCommand().equals("3"))
			Add(3);
		else if(e.getActionCommand().equals("4"))
			Add(4);
		else if(e.getActionCommand().equals("5"))
			Add(5);
		else if(e.getActionCommand().equals("6"))
			Add(6);
		else if(e.getActionCommand().equals("7"))
			Add(7);
		else if(e.getActionCommand().equals("8"))
			Add(8);
		else if(e.getActionCommand().equals("9"))
			Add(9);
		else if(e.getActionCommand().equals("0"))
			Add(0);
		else if(e.getActionCommand().equals("X"))
			Add2('X');
		else if(e.getActionCommand().equals("÷"))
			Add2('÷');
		else if(e.getActionCommand().equals("+"))
			Add2('+');
		else if(e.getActionCommand().equals("-"))
			Add2('-');	
		else if(e.getActionCommand().equals("="))
		{
			c.top1++;
			c.a[c.top1]=sum;
			if(c.top2!=-1)//当有运算符时才进行计算
				sum=Calculate(c.a,c.b,c.top1,c.front);
			c.flag=1;	
			c.count=0;
			Print();
		}
		else if(e.getActionCommand().equals("+/-"))
		{
			sum=-sum;
			if(c.count==0)
				c.a[c.top1]=sum;
			Print();
		}
		else if(e.getActionCommand().equals("1/x"))
		{
			sum=1/sum;
			if(c.count==0)
				c.a[c.top1]=sum;
			Print();
		}
		else if(e.getActionCommand().equals("x*x"))
		{
			sum=sum*sum;
			if(c.count==0)
				c.a[c.top1]=sum;
			Print();
		}
		else if(e.getActionCommand().equals("√"))
		{
			sum=Math.sqrt(sum);
			if(c.count==0)
				c.a[c.top1]=sum;
			Print();
		}
		else if(e.getActionCommand().equals("."))
		{
			if(c.flag==0) c.flag=1;
			else c.flag=0;
			Print();
		}
		else if(e.getActionCommand().equals("  ←  "))
		{	
			sum=Double.valueOf(text.getText());
			int n=(int)sum;
			if(c.count==0)	JOptionPane.showMessageDialog(null,"计算结果不能退格！",null, JOptionPane.ERROR_MESSAGE);//计算结果不能退格
			else if(sum%1==0)
			{
				n=n/10;
				sum=(double)n;
			}
			else
			{
				c.sum=c.sum/10;
				sum=(sum*c.sum)/1;
				n=(int)sum;
				sum=(double)n/c.sum;
			}		
			if(c.count==0)
				c.a[c.top1]=sum;
			Print();
		}
		else if(e.getActionCommand().equals("全清"))
		{
			Delate();
			sum=0;
			Print();
		}
		else if(e.getActionCommand().equals("清屏"))
		{
			sum=0;
			Print();
		}
	}
	public void Set(JButton b,int gridwidth,int gridheight,int weightx,int weighty,int x,int y,GridBagConstraints gbs,GridBagLayout gbl,int flag)//设置每个按钮的位置
	{
		b.addActionListener(this);
		b.setForeground(Color.BLACK);
		if(flag==1)
		{
			b.setForeground(Color.WHITE);
			b.setBackground(new Color(128,128,128));
		}
		b.setFont(new java.awt.Font("华文琥珀", 5, 18));	
		gbs.gridwidth = gridwidth;
		gbs.gridheight=gridheight;
		gbs.weightx=weightx;
		gbs.weighty=weighty;
		if(x!=0)
		{
			gbs.gridx=x;
			gbs.gridy=y;
		}
		gbl.setConstraints(b, gbs);
		this.add(b);
	}
	public void Add(int n)//点击数字按钮
	{
		if(c.count==0)//全清
		{	
			Delate();
			sum=0;
		}
		if(c.flag==0)//小数点
		{
			c.sum*=10;
			sum*=c.sum;
			sum=sum+n;
			sum/=c.sum;
		}
		else
			sum=sum*10+n;
		Print();
	}
	public void Add2(char n)//点击运算按钮
	{
		c.flag=1;
		c.sum=1;
		if(c.count==1)
		{
			c.top1++;
			c.top2++;
			c.a[c.top1]=sum;
			c.b[c.top2]=n;
			sum=Calculate(c.a,c.b,c.top1,c.front);
			Print();
		}
		else
		{
			c.top2++;
			c.b[c.top2]=n;
		}
		if(c.top1!=0&&c.top1!=-1)
			c.front++;
		c.count=1;
		sum=0;
	}
	public void Print()
	{
		if(sum%1==0)//没有小数部分时只显示整数，否则都显示
			text.setText(String.valueOf((int)sum));
		else if(sum%1!=0&&c.flag==0)
			text.setText(String.valueOf(sum));
		else
		{
			sum=(int)(sum*10000+0.5)/1;
			sum=sum/10000;
			text.setText(String.valueOf(sum));
		}
	}
	public double Calculate(double[] a,char[] b,int top1,int front)
	{
			switch(b[front])
			{
			case 'X':
				if(top1==0)
					return a[top1];
				else 
				{
					a[top1]=a[top1-1]*a[top1];
					return a[top1];
				}
			case '÷':
				if(top1==0)
					return a[top1];
				else 
				{
					if(a[top1]==0)
					{
						JOptionPane.showMessageDialog(null,"除数不能为0！已全清，请重新计算！",null, JOptionPane.ERROR_MESSAGE);//计算结果不能退格
						Delate();
						return 0;
					}	
					a[top1]=a[top1-1]/a[top1];
					return a[top1];
				}
			case '+':
				if(top1==0)
					return a[top1];
				else 
				{
					a[top1]=a[top1-1]+a[top1];
					return a[top1];
				}
			case '-':
				if(top1==0)
					return a[top1];
				else 
				{
					a[top1]=a[top1-1]-a[top1];
					return a[top1];
				}
			}
		return 0;
	}
	public void Delate()//全清
	{
		c=new calculate();
	}
	public static void main(String args[])
	{
		new JCalculator();
	}
}
class calculate
{
	public double[] a=new double[100];//数字栈
	public char[] b=new char[100];//符号栈
	int top1=-1,top2=-1,front=0,count=1,flag=1,sum=1;//top1为数字栈,top2为运算符栈,count判断按下'='后是否要全清，flag判断是否启动小数点，sum为小数点功能.
}