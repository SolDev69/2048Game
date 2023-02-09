import java.awt.*;

public class Box extends Rectangle {
	int width, height, num, x, y;

    Box(int x, int y, int width, int height, int num) {
        this.width = width; this.height = height; this.num = num; this.x = x; this.y = y;
    }

    public void draw(Graphics g, Component c) {
        Logger.log(num);
        switch(num) {
            case 2:
                g.setColor(Color.YELLOW);
                break;
        }
    	g.fillRect(x, y, width, height);
    }
}