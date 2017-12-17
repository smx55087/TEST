import javax.swing.*;
public class JComplex extends JFrame
{
	public JTextField text1,text2;
	public JLabel label1,label2;
	public JComplex()
	{
	    text1=new JTextField(10);
	    text1.setHorizontalAlignment(JTextField.RIGHT);
	    text2=new JTextField(10);
	    text2.setHorizontalAlignment(JTextField.RIGHT);
	    label1=new JLabel("+");
	    label2=new JLabel("i");
	}
}