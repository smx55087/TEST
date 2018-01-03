public class Complex 
{
	public double r,x;
	public Complex(	String r,String x) 
	{
		try 
		{
			this.r=Double.parseDouble(r);
			this.x=Double.parseDouble(x);
		}
		catch(NumberFormatException ex)
		{
			new MessageJDialog().showing2(ex);
			return;
		}
	}
	public void Add(Complex a)
	{		
		this.r=a.r+this.r;
		this.x=a.x+this.x;
	}
	public void Subtract(Complex a)
	{	
		this.r=this.r-a.r;
		this.x=this.x-a.x;
	}
	public void Multiply(Complex a)
	{	
		Complex c2=new Complex("0","0");
		c2.r=this.r;
		c2.x=this.x;
		this.r=c2.r*a.r-c2.x*a.x;
		this.x=c2.r*a.x+c2.x*a.r;
	}
	public void Divided(Complex a)
	{	
		Complex c2=new Complex("0","0");
		c2.r=this.r;
		c2.x=this.x;
		if(a.r==0&&a.x==0)
			new MessageJDialog().showing();
		this.r=(c2.r*a.r+c2.x*a.x)/(a.r*a.r+a.x*a.x);
		this.x=(c2.x*a.r-c2.r*a.x)/(a.r*a.r+a.x*a.x);
	}
}
