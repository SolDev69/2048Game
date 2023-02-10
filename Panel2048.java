import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;

public class Panel2048 extends JPanel implements KeyListener {

	ArrayList<Box> boxes = new ArrayList<>();

	int width, height;


	Panel2048(int width, int height) {
		this.width = width;
		this.height = height;
		boxes.add(new Box(0, 0, 100, 100, 2));
		boxes.add(new Box(100, 100, 100, 100, 2));
		boxes.add(new Box(300, 100, 100, 100, 2));
		addKeyListener(this);
		setFocusable(true);
    	Thread thread = new Thread(() -> {
    		while (true) {
    			this.update();
    			try {
    				Thread.sleep(10);
    			} catch (InterruptedException ex) {
    				ex.printStackTrace();
    			}
    		}
   		});
   		thread.start();
	}

    public void paintComponent(Graphics g) {
    	super.paintComponent(g);
        for (Box b : boxes)
            b.draw(g, this);
    }
    public void update() {
//    	for (Box b : boxes) {
    	for(int i0 = 0; i0 < boxes.toArray().length; i0++) {
    		for(int i1 = 0; i1 < boxes.toArray().length; i1++) {
    			if (i0 != i1) {
    				if (boxes.get(i0).num == boxes.get(i1).num) {
		    			if (boxes.get(i0).x == boxes.get(i1).x) {
		    				if(boxes.get(i0).y == boxes.get(i1).y) {
			    				boxes.get(i0).num++; // Check if two numbers are equal
			    				boxes.remove(i1);
			    			}
		    			}
		    		} 
	    		}
    		}
    	}
//	    }
    	//Logger.log(boxes.toString());
    	repaint();
    }
	public void keyTyped(KeyEvent e) {

    }
    // Box getBoxAt(int x, int y) {
    // 	Object[] boxArray = boxes.toArray();
    // 	for (int i0 = 0; i0 < boxArray.length; i0++) {
    // 		for (int i1 = 0; i1 < boxArray.length; i1++) {
    // 			if (boxes.get(i0).x)
    // 		}
    // 	}
    // }
    Box getBoxAt(int x, int y) {
    	for (Box b : boxes)
    		if (b.x == x && b.y == y)
    			return b;
    	return null;
    }
    boolean doesBoxExistAt(int x, int y) {
    	for (Box b : boxes)
    		if (b.x == x && b.y == y)
    			return true;
    	return false;
    }
    public void keyPressed(KeyEvent e) {
    	if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
    		for (Box b : boxes) {
    			while (b.x < (this.height - b.height)) {
    				if (doesBoxExistAt(b.x + 100, b.y) && (getBoxAt(b.x + 100, b.y).num == b.num)) {
    					b.x += 100;
    				} else if (!doesBoxExistAt(b.x+100, b.y)) {
    					b.x += 100;
    				}
    			}
    			//System.out.println("!");
    		}
    	}    	
    	if (e.getKeyCode() == KeyEvent.VK_LEFT) {
    		for (Box b : boxes) {
    			while (b.x > 0)
    				b.x -= 100;
    			//System.out.println("!");
    		}
    	}
    	if (e.getKeyCode() == KeyEvent.VK_UP) {
    		for (Box b : boxes) {
    			while (b.y > 0)
    				b.y -= 100;
    			//System.out.println("!");
    		}
    	}
    	if (e.getKeyCode() == KeyEvent.VK_DOWN) {
    		for (Box b : boxes) {
    			while (b.y < (this.height - b.height))
    				b.y += 100;
    			//System.out.println("!");
    		}
    	} 
    }

    public void keyReleased(KeyEvent e) {

    }
}