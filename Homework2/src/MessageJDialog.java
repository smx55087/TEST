import javax.swing.*;

public class MessageJDialog extends JDialog
{
	private static JFrame j=new JFrame();
	private JLabel jd;
	public MessageJDialog()
	{
		super(j,"警告",true);
		this.setSize(350,100);
		jd=new JLabel("",JLabel.CENTER);
		this.add(jd);
		this.setDefaultCloseOperation(HIDE_ON_CLOSE);
	}
	public void showing()
	{
		jd.setText("除数不能为0！");
		this.setLocation(j.getX()+700, j.getY()+350);
		this.setVisible(true);
	}
	public void showing2(NumberFormatException ex)
	{
		jd.setText(""+ex.toString());
		this.setLocation(j.getX()+700, j.getY()+350);
		this.setVisible(true);
	}
}
