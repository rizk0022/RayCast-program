package raycast.entity.geometry;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import raycast.entity.DrawableObject;

public class PolyShape implements DrawableObject<PolyShape> {

	private int pointCount;
	private double[][] points;
	private double minX;
	private double minY;
	private double maxX;
	private double maxY;
	private double strokeWidth;
	private Color fill;
	private Color stroke;
	private RectangleBounds bounds;

	public PolyShape() {
		strokeWidth=1;
		fill=null;
		stroke=Color.BLACK;
	}

	public PolyShape randomize (double centerX, double centerY, double size, int minPoints, int maxPoints) {
		return null;

	}



	public PolyShape setPoints (double...nums) {
		minX = maxX=nums[0];
		minY = maxY=nums[1];
		pointCount = nums.length/2;
		points = new double[2][pointCount];
		for (int i=0,j=0;i<nums.length;j++,i+=2) {
			updateMinMax(nums[i], nums[i+1]);
			points[0][j]=nums[i];
			points[1][j]=nums[i+1];
		}
		bounds = new RectangleBounds(minX, minY, maxX-minX, maxY-minY);

		return this;

	}

	private void updateMinMax (double x, double y) {
		if(x<minX)
			minX=x;
		if (x>maxX) 
			maxX=x;
		if (y<minY)
			minY=y;
		if(y>maxY)
			maxY=y;
	}

	public int pointCount() {
		return pointCount;

	}

	public double[][] points() {
		return points;

	}

	public double pX(int index) {
		return points[0][index];

	}

	public double pY(int index) {
		return points[1][index];

	}

	public void drawCorners(GraphicsContext gc) {
		gc.setFill(Color.BLACK);
		for (int i = 0; i < pointCount; i++) {
			gc.fillText(Integer.toString(i), points[0][i] - 5, points[1][i] - 5);
			gc.fillOval(points[0][i] - 5, points[1][i] - 5, 10, 10);
		}
	}


	public RectangleBounds getBounds() {
		return bounds;

	}

	@Override
	public PolyShape setFill(Color color) {
		fill = color;
		return this;
	}

	@Override
	public PolyShape setStroke(Color color) {
		// TODO Auto-generated method stub
		stroke = color;
		return this;
	}

	@Override
	public PolyShape setWidth(double width) {
		// TODO Auto-generated method stub
		strokeWidth=width;
		return this;
	}

	@Override
	public Color getFill() {
		// TODO Auto-generated method stub
		return fill;
	}

	@Override
	public Color getStroke() {
		// TODO Auto-generated method stub
		return stroke;
	}

	@Override
	public double getWidth() {
		// TODO Auto-generated method stub
		return strokeWidth;
	}


	@Override
	public void draw(GraphicsContext gc) {

		gc.setLineWidth(strokeWidth);
		if (stroke != null) {
			gc.setStroke(stroke);
			gc.strokePolygon(points[0], points[1], pointCount);
		}
		if (fill != null) {
			gc.setFill(fill);
			gc.fillPolygon(points[0], points[1], pointCount);
		}

	}
}
