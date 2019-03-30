package raycast.animator;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class StaticShapes extends AbstractAnimator{
	
	private static final Color BACKGROUND = Color.AQUA;
	

	@Override
	void handle(long now, GraphicsContext gc) {
		// TODO Auto-generated method stub
		clearAndFill(gc, Color.LIGHTBLUE);
		for (int i=0;i<c.shapes().size();i++) {
			c.shapes().get(i).draw(gc);
		}
		
	}


	@Override
	public String toString() {
		return "Static Shapes";
	}
	
	

}
