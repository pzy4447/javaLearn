package Swing;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class JToolBarTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				JToolBarFrame frame = new JToolBarFrame();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});
	}

}
class JToolBarFrame extends JFrame{
	public JToolBarFrame(){
		setTitle("JToolBarFrame");
		setSize(400, 400);
		//add a panel for color change
		panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		
		//setup actions
		Action blueAction = new ColorAction("Blue", new ImageIcon("blue-ball.gif"), Color.BLUE);
		Action yellowAction = new ColorAction("Yellow", new ImageIcon("yellow-ball.gif"), Color.YELLOW);
		Action redAction = new ColorAction("Red", new ImageIcon("red-ball.gif"), Color.RED);
		Action exitAction = new AbstractAction("Exit", new ImageIcon("exit.gif"))
		{	public void actionPerformed(ActionEvent e){
				System.exit(0);
			}
		};		
		exitAction.putValue(Action.SHORT_DESCRIPTION ,"Exit");
		
		//add toolBar
		JToolBar bar = new JToolBar("JToolBar");
		bar.add(blueAction);
		bar.add(yellowAction);
		bar.add(redAction);
		bar.addSeparator();
		bar.add(exitAction);
		bar.add(new JButton("Hello"));
		bar.add(new JMenu("world"));
		add(bar, BorderLayout.NORTH);
		
		//populate menu
		JMenu menu = new JMenu("Color");
		menu.add(blueAction);
		menu.add(yellowAction);
		menu.add(redAction);
		menu.add(exitAction);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.add(menu);
		setJMenuBar(menuBar);
	}
	
	
	private JPanel panel;
	
	class ColorAction extends AbstractAction{

		public ColorAction(String name, Icon icon, Color c){
			putValue(Action.NAME , name);
			putValue(Action.SMALL_ICON , icon);
			putValue(Action.SHORT_DESCRIPTION , name);
			putValue("Color", c);
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			Color c = (Color)getValue("Color");
			panel.setBackground(c);
		}
	}
}

