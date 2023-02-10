import java.awt.*;
import java.io.FileWriter;

public class Box extends Rectangle {
	int num;

    Box(int x, int y, int width, int height, int num) {
        super.width = width; 
        super.height = height; 
        this.num = num; 
        super.x = x; 
        super.y = y;
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
            case 4:
                g.setColor(Color.BLACK);
                break;
        }
    	g.fillRect(x, y, width, height);
    }
}