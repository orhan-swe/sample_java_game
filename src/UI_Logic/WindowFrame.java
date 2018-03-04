package UI_Logic;

import java.awt.Dimension;

import javax.swing.JFrame;

import UI_Logic.ObjectDrawers.BlockDrawer;
import UI_Logic.ObjectDrawers.ObjectDrawer;
import UI_Logic.ObjectDrawers.PlayerDrawer;

public class WindowFrame extends JFrame{

	
	public WindowFrame(int w, int h, String title, CanvasDrawer cd) {
	
		cd.setPreferredSize(new Dimension(w,h));
		cd.setMaximumSize(new Dimension(w,h));
		cd.setMinimumSize(new Dimension(w,h));
		

		add(cd);
		pack();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);;
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
}
