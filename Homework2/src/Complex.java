public class Complex 
{
	public double r,x;
	public Complex(	double r,double x) {this.r=r;this.x=x;}
	public void Add(Complex a)
	{		
		try 
		{
			this.r=a.r+this.r;
			this.x=a.x+this.x;
		}
		catch(NumberFormatException ex)
		{
			new MessageJDialog().showing2(ex);
		}
	}
	public void Subtract(Complex a)
	{	
		try 
		{
			this.r=this.r-a.r;
			this.x=this.x-a.x;
		}
		catch(NumberFormatException ex)
		{
			new MessageJDialog().showing2(ex);
		}
	}
	public void Multiply(Complex a)
	{	
		Complex c2=new Complex(0,0);
		c2.r=this.r;
		c2.x=this.x;
		try 
		{
			this.r=c2.r*a.r-c2.x*a.x;
			this.x=c2.r*a.x+c2.x*a.r;
		}
		catch(NumberFormatException ex)
		{
			new MessageJDialog().showing2(ex);
		}
	}
	public void Divided(Complex a)
	{	
		Complex c2=new Complex(0,0);
		c2.r=this.r;
		c2.x=this.x;
		if(a.r==0&&a.x==0)
			new MessageJDialog().showing();
		try 
		{
			this.r=(c2.r*a.r+c2.x*a.x)/(a.r*a.r+a.x*a.x);
			this.x=(c2.x*a.r-c2.r*a.x)/(a.r*a.r+a.x*a.x);
		}
		catch(NumberFormatException ex)
		{
			new MessageJDialog().showing2(ex);
		}
	}
}