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
	public void merge() {
		for(int i0 = 0; i0 < boxes.toArray().length; i0++) {
			for(int i1 = 0; i1 < boxes.toArray().length; i1++) {
				if (i0 != i1) {
					if (boxes.get(i0).num == boxes.get(i1).num) {
						if (boxes.get(i0).x == boxes.get(i1).x) {
							if(boxes.get(i0).y == boxes.get(i1).y) {
								boxes.get(i0).num += 2; // Check if two numbers are equal
								boxes.remove(i1);
							}
						}
					} 
				}
			}
		}
	}
    public void keyPressed(KeyEvent e) {
    	if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
    		for (Box b : boxes) {
    			while (b.x < (this.width - b.width)) {
    				if (doesBoxExistAt(b.x + 100, b.y) && (getBoxAt(b.x + 100, b.y).num == b.num)) {
						if (doesBoxExistAt(b.x+100, b.y)) {
							b.x+=100;
							this.merge();
						}
    					
    				} else if (!doesBoxExistAt(b.x+100, b.y)) {
    					b.x += 100;
    				} 
					//else if (b.x)
    			}
    			//System.out.println("!");
    		}
    	}    	
    	if (e.getKeyCode() == KeyEvent.VK_LEFT) {
    		for (Box b : boxes) {
    			while (b.x > 0) {
    				if (doesBoxExistAt(b.x - 100, b.y) && (getBoxAt(b.x - 100, b.y).num == b.num)) {
    					b.x -= 100;
						this.merge();
    				} else if (!doesBoxExistAt(b.x-100, b.y)) {
    					b.x -= 100;
    				} else if (b.x == 100) break;
    			}
    			//System.out.println("!");
    		}
    	}
    	if (e.getKeyCode() == KeyEvent.VK_UP) {
    		for (Box b : boxes) {
    			while (b.y > 0) {
					if (doesBoxExistAt(b.x, b.y - 100) && (getBoxAt(b.x, b.y - 100).num == b.num)) {
    					b.y -= 100;
    				} else if (!doesBoxExistAt(b.x, b.y - 100)) {
    					b.y -= 100;
    				} else if (b.y == 100) break;
				}
    				
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