package interfazea;

import javax.swing.JFrame;

public class LeihoNagusia extends JFrame{
	
	private Zelaia zelaia;
	
	 public static void main(String[] args) {
		 new LeihoNagusia();
	 }
	 
	 public LeihoNagusia() {
		 this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 this.setTitle("PingPoners");
	     this.setSize(750,550);
	     this.setResizable(false);
	     this.setVisible(true);
	     
	     zelaia = new Zelaia();
	     this.add(zelaia);
	     while(true) {
	    	 zelaia.repaint();
	     }
	 }

}
