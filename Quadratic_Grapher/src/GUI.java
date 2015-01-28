import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class GUI extends Frame implements ActionListener{

	public TextField avalue;
	public TextField bvalue;
	public TextField cvalue;
	
	Canvas canvas;
	
	Button solve;
	Label equation;
	
	Label solution_Plus;
	Label solution_Minus;
	
	public GUI(int width, int height){
		
		setTitle("Quadratic Solver");
		setSize(width, height);

		
		Panel terms = new Panel();
		terms.setLayout(new GridLayout(2,3));
		
		Label aterm = new Label("A term:");
		terms.add(aterm);
		
		Label bterm = new Label("B term:");	
		terms.add(bterm);
		
		Label cterm = new Label("C term:");
		terms.add(cterm);
		
		avalue = new TextField("0",1);
		terms.add(avalue);
		bvalue = new TextField("0",1);
		terms.add(bvalue);
		cvalue = new TextField("0",1);
		terms.add(cvalue);

		terms.setVisible(true);
		
		Panel generate = new Panel();
		generate.setLayout(new GridLayout(2,1));
		solve = new Button("Solve!");   
		solve.addActionListener(this);
		generate.add(solve);
		equation = new Label(avalue.getText() + "X^2 + " + bvalue.getText() + "X + " + cvalue.getText() + " = 0");
		generate.add(equation);
		
		Panel solutions = new Panel();
		solutions.setLayout(new GridLayout(2,1));
		solution_Plus = new Label("SOLUTION: NULL");
		solutions.add(solution_Plus);
		solution_Minus = new Label("SOLUTION: NULL");
		solutions.add(solution_Minus);
		solutions.setSize(100, 50);
		
		
		setLayout(new BorderLayout());
		add(terms, BorderLayout.NORTH);
		add(generate,BorderLayout.WEST);
		add(solutions,BorderLayout.EAST);
		add(new Graph(), BorderLayout.SOUTH);
		setVisible(true);
		repaint();
		
	}

	
	
	@Override
	public void actionPerformed(ActionEvent evt) {
		if(avalue.getText() == null) avalue.setText("0");
		if(bvalue.getText() == null) bvalue.setText("0");
		if(cvalue.getText() == null) cvalue.setText("0");
		
		equation.setText(avalue.getText() + "X^2 + " + bvalue.getText() + "X + " + cvalue.getText() + " = 0");
		
		Quad_Eq qeq = new Quad_Eq();
		
		float sp = qeq.QEq_Plus(Float.valueOf(avalue.getText()), Float.valueOf(bvalue.getText()), Float.valueOf(cvalue.getText()));
		float sm = qeq.QEq_Minus(Float.valueOf(avalue.getText()), Float.valueOf(bvalue.getText()), Float.valueOf(cvalue.getText()));
		
		solution_Plus.setText("SOLUTION: "+ sp);
		solution_Minus.setText("SOLUTION: "+ sm);
		setSize(351, 350);
		setSize(350, 350);

		repaint();

	}
	   class Graph extends Canvas {

		      public Graph() {
		         setBackground (Color.WHITE);
		         setSize(300, 200);
		      }
		      
		      public void paint(Graphics g){ 
		    	  
		    		super.paint(g);
		    		Graphics2D g2 = (Graphics2D)g;
		    		Quad_Eq qeq = new Quad_Eq();
		    		
		    		int min = (int)qeq.getY(Float.valueOf(avalue.getText()), Float.valueOf(bvalue.getText()), Float.valueOf(cvalue.getText()),0);
		    		int max =(int)qeq.getY(Float.valueOf(avalue.getText()), Float.valueOf(bvalue.getText()), Float.valueOf(cvalue.getText()),35);
		    		int dist = (max-min)/100;
		    			
		    		g2.drawLine(175, 0, 175, 200);	
		    		g2.drawLine(0, 100, 350, 100);
		    		
		    		g2.drawString(""+max, 175, 15);
		    		
		    		g2.drawString("-"+max, 175, 195);	
		    			for(int x = 0;x <= 70; x++){
		    			
		    				
		    			float y2 = -qeq.getY(Float.valueOf(avalue.getText()), Float.valueOf(bvalue.getText()), Float.valueOf(cvalue.getText()), x-36f)+100*dist;
		    				
		    			
		    			float y = -qeq.getY(Float.valueOf(avalue.getText()), Float.valueOf(bvalue.getText()), Float.valueOf(cvalue.getText()), x-35f)+100*dist;
		    			
		    			
		    			if(x==0)g2.drawLine(0, (int)(y/dist), 0, (int)(y/dist));
		    			else g2.drawLine(5*x-5, (int)(y2/dist), 5*x, (int)(y/dist));
		    		}
		    			
		      }
		   
	   }
	
}
