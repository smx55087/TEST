import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.event.*;
public class Windows extends JFrame implements ActionListener
{
	int i=0;
	static JFrame jf=new JFrame();
    GridBagLayout gbl = new GridBagLayout();  
    GridBagConstraints gbs = new GridBagConstraints(); 
    JComplex[] j=new JComplex[100];
    JComboBox[] jc=new JComboBox[10];
	private JButton b1,b2;
	String[] str = {"+","-","*","/","空"}; 
	public Windows ()
	{
		jf.setLocation(700,300);
		jf.setResizable(false);
		jf.setBackground(java.awt.Color.lightGray);
		jf.setDefaultCloseOperation(EXIT_ON_CLOSE);
		jf.setLayout(gbl); 
	    gbs.fill=GridBagConstraints.BOTH;
	    gbs.gridwidth=1;
	    gbs.weightx=0;
	    gbs.weighty=1;
	    gbs.insets = new Insets(5,5, 5, 5);
	    b1=new JButton("+");
	    b2=new JButton("=");
	    b1.addActionListener(this);	
	    b2.addActionListener(this);
	    gbl.setConstraints(b1, gbs);
	    gbl.setConstraints(b2, gbs);
	    //添加组件
	    jf.add(b1);
	    Add();
	    jf.add(b2);
	    Add();
	    j[1].text1.setEditable(false);
	    j[1].text2.setEditable(false);
	    //显示面板
	    jf.pack();
	    jf.setVisible(true);
	}
	public void Add()
	{
	    gbs.gridwidth=1;
	    gbs.weightx=1;
	    j[i]=new JComplex();
	    gbl.setConstraints(j[i].text1, gbs);
	    gbl.setConstraints(j[i].text2, gbs);
	    j[i].text2.addActionListener(this);
	    gbs.gridwidth=1;
	    gbs.weightx=0;
	    gbl.setConstraints(j[i].label1, gbs);
	    gbs.gridwidth = GridBagConstraints.REMAINDER;
	    gbl.setConstraints(j[i].label2, gbs);
	    jf.add(j[i].text1);
	    jf.add(j[i].label1);
	    jf.add(j[i].text2);
	    jf.add(j[i].label2);
	    i++;
	}
	public void actionPerformed(ActionEvent ev)
	{
		int k;
		for(k=0; k<i-2;k++)
		{
			if(jc[k].getSelectedItem().equals("空"))
			{
			    j[k+2].text1.setEditable(false);
			    j[k+2].text2.setEditable(false);
			    j[k+2].text1.setText("");
			    j[k+2].text2.setText("");
			}
			else
			{
			    j[k+2].text1.setEditable(true);
			    j[k+2].text2.setEditable(true);
			}
		}
		if(ev.getActionCommand().equals("+"))
		{
		    gbs.gridwidth=1;
		    gbs.weightx=0;
			jc[i-2]=new JComboBox(str);
			jc[i-2].addActionListener(this);	
			gbl.setConstraints(jc[i-2], gbs);
			jf.add(jc[i-2]);
			Add();
			//重新添加最后一行组件
 		    jf.add(b2);
		    jf.add(j[1].text1);
		    jf.add(j[1].label1);
		    jf.add(j[1].text2);
		    jf.add(j[1].label2);
			jf.pack();	
		}	
		if(ev.getActionCommand().equals("="))
		{
			Complex[] c=new Complex[100];
			c[0]=new Complex(j[0].text1.getText(),j[0].text2.getText());
			for(k=0; k<i-2;k++)
			{
				if(jc[k].getSelectedItem().equals("+"))
				{
					c[k+2]=new Complex(j[k+2].text1.getText(),j[k+2].text2.getText());
					c[0].Add(c[k+2]);
				}
				else if(jc[k].getSelectedItem().equals("-"))
				{
					c[k+2]=new Complex(j[k+2].text1.getText(),j[k+2].text2.getText());
					c[0].Subtract(c[k+2]);
				}
				else if(jc[k].getSelectedItem().equals("*"))
				{
					c[k+2]=new Complex(j[k+2].text1.getText(),j[k+2].text2.getText());
					c[0].Multiply(c[k+2]);
				}
				else if(jc[k].getSelectedItem().equals("/"))
				{
					c[k+2]=new Complex(j[k+2].text1.getText(),j[k+2].text2.getText());
					c[0].Divided(c[k+2]);
				}
			}
			j[1].text1.setText(String.valueOf(c[0].r));
			if(c[0].x<0)
			{
				j[1].label1.setText("-");
				j[1].text2.setText(String.valueOf(-c[0].x));
			}
			else
			{	j[1].label1.setText("+");
				j[1].text2.setText(String.valueOf(c[0].x));
			}
			MaxLong();//限制文本框显示长度
		}
	}
	public void MaxLong() {  
	    String s = j[1].text1.getText();  
	    String s2 =j[1].text2.getText();  
	    if(s.length()>= 10)
	    {
	    	s=s.substring(0,15);
	    }  
	    if(s2.length()>= 10)
	    {
		    s2=s2.substring(0,15);
	    }
	    j[1].text1.setText(s);
	    j[1].text2.setText(s2);
	} 
	public static void main(String arg[])
	{ 
		new Windows();
		
	}

}
