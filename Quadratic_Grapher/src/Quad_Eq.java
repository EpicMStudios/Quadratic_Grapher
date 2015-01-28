
public class Quad_Eq {

	public Quad_Eq(){
		
	}
	
	public float QEq_Plus(float a, float b, float c){
		float x = (float) (-b + (Math.sqrt((b*b)-4*a*c)) / (2*a));
		return x;
	}
	public float QEq_Minus(float a, float b, float c){
		float x = (float) (-b - (Math.sqrt((b*b)-4*a*c)) / (2*a));
		return x;
	}
	
	public float getY(float a, float b, float c, float x){
		float y = a*(x*x) + b*x + c;
		return y;
	}

}
