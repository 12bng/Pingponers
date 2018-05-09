package interfazea;

import javax.swing.JFrame;

public class LeihoNagusia extends JFrame{
	
	private Zelaia zelaia;
	
	 public static void main(String[] args) {
		 new LeihoNagusia(args[0],args[1]);
	 }
	 
	 public LeihoNagusia(String pLengoaia, String pJokoMota) {
		 this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 this.setTitle("PingPoners");
	     this.setSize(1020,620);
	     this.setResizable(false);
	     this.setVisible(true);
	     
	     zelaia = new Zelaia(pLengoaia,pJokoMota);
	     this.add(zelaia);
	 }

}
