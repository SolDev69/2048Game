import java.awt.*;
import java.io.FileWriter;

public class Box extends Rectangle {
	int width, height, num, x, y;

    Box(int x, int y, int width, int height, int num) {
        this.width = width; 
        this.height = height; 
        this.num = num; 
        this.x = x; 
        this.y = y;
        Logger.log(Integer.toString(x) + " x");
        Logger.log(Integer.toString(this.x) + " this.x");
    }

    public void draw(Graphics g, Component c) {
        // Logger.log(Integer.toString(x) + " x");
        
        // try {
        //     FileWriter fw = new FileWriter("./log.txt", true);
        //     fw.write(Integer.toString(this.x) + " this.x\n");
        //     fw.write(Integer.toString(this.y) + " this.y\n");
        //     fw.write("\n");
        //     fw.close();
        // } catch (Exception e) {}
        Logger.log(Integer.toString(this.x) + " this.x");
        Logger.log(Integer.toString(this.y) + " this.y");
        Logger.log("");
        //Logger.log(num);
        switch(num) {
            case 2:
                g.setColor(Color.YELLOW);
                break;
        }
    	g.fillRect(x, y, width, height);
    }
}