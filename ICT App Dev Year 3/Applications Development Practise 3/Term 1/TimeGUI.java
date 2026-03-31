import java.awt.*;
import java.awt.event.*;

class TimeGUI implements ActionListener {
	private Frame mainFrame;
	private Panel panelTop;
	private Panel panelCenter;
	private Panel panelBelow;
	private Button buttonExit;
	private Label labelCountry[] = new Label[6];
	private Label labelTime[] = new Label[6];
  	  
	public TimeGUI() {
	    mainFrame = new Frame("My TimeZone program");
    	panelTop = new Panel();
    	panelCenter = new Panel();
    	panelBelow = new Panel();

    	buttonExit      = new Button("Exit");
    	buttonExit.addActionListener(this);

    	labelCountry[0] = new Label("London");
    	labelCountry[1] = new Label("Japan");
    	labelCountry[2] = new Label("France");
    	labelCountry[3] = new Label("Amsterdam");
    	labelCountry[4] = new Label("South Africa");
    	labelCountry[5] = new Label("Namibia");
    	
    	labelTime[0] = new Label("00:00");
    	labelTime[1] = new Label("00:00");
    	labelTime[2] = new Label("00:00");
    	labelTime[3] = new Label("00:00");
    	labelTime[4] = new Label("00:00");
    	labelTime[5] = new Label("00:00");
    	
    	panelTop.setLayout(new GridLayout(2, 3));
    	panelTop.add(labelCountry[0]);
    	panelTop.add(labelCountry[1]);
    	panelTop.add(labelCountry[2]);
    	panelTop.add(labelTime[0]);
    	panelTop.add(labelTime[1]);
    	panelTop.add(labelTime[2]);
		
		panelCenter.setLayout(new GridLayout(2, 3));
    	panelCenter.add(labelCountry[3]);
    	panelCenter.add(labelCountry[4]);
    	panelCenter.add(labelCountry[5]);
    	panelCenter.add(labelTime[3]);
    	panelCenter.add(labelTime[4]);
    	panelCenter.add(labelTime[5]);
    	
		panelBelow.add(buttonExit);

        mainFrame.add("North", panelTop);
        mainFrame.add("Center", panelCenter);
    	mainFrame.add("South", panelBelow);
    	mainFrame.pack();
    	mainFrame.show();
	}
	
	public void setGUI() {
		Calc Obj1 = new Calc(labelTime[0], -2);
		Calc Obj2 = new Calc(labelTime[1], 7);
		Calc Obj3 = new Calc(labelTime[2], 2);
		Calc Obj4 = new Calc(labelTime[3], 1);
		Calc Obj5 = new Calc(labelTime[4], 0);
		Calc Obj6 = new Calc(labelTime[5], -1);
		Thread t1 = new Thread(Obj1);
		Thread t2 = new Thread(Obj2);
		Thread t3 = new Thread(Obj3);
		Thread t4 = new Thread(Obj4);
		Thread t5 = new Thread(Obj5);
		Thread t6 = new Thread(Obj6);
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		t6.start();
	}

	public void actionPerformed(ActionEvent evt) {
		if (evt.getSource() == buttonExit)
		{
			System.exit(0);
		}
	}

	public static void main(String args[]) {
		new TimeGUI().setGUI();
	}
} //********class ends here*********//
