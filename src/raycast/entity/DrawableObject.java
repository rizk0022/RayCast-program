package raycast.entity;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * an interface used on drawable objects.
 * 
 * @param <T> - the type of class the implements this interface.
 * @author Shahriar (Shawn) Emami
 * @version Jan 12, 2019
 */
public interface DrawableObject<T>{
	/**
	 * set the {@link Color} to be used when filling the shape
	 * @param color - {@link Color} color object
	 * @return the instance of current object
	 */
	T setFill( Color color);
	
	/**
	 * set the {@link Color} to be used when stroking the shape
	 * @param color - {@link Color} color object
	 * @return the instance of current object
	 */
	T setStroke( Color color);
	
	/**
	 * set the stroke width to be used when stroking the shape
	 * @param width - stroke width
	 * @return the instance of current object
	 */
	T setWidth( double width);
	
	/**
	 * get the current fill {@link Color}
	 * @return {@link Color}
	 */
	Color getFill();

	/**
	 * get the current stroke {@link Color}
	 * @return {@link Color}
	 */
	Color getStroke();

	/**
	 * get the current stroke width
	 * @return stroke width
	 */
	double getWidth();
	
	/**
	 * draw the shape given the {@link GraphicsContext}
	 * @param gc - {@link GraphicsContext} object
	 */
	void draw( GraphicsContext gc);
}