package utils;

import java.awt.Point;

public class Toolkit {
	public static void sleep(int ms) {
		try {
			Thread.sleep(ms);
		}
		catch (Exception e) {
			
		}
	}
	
	public static int calDistance(Point e1Loc, Point e1Size, Point e2Loc, Point e2Size) {
		int distanceX = calDistance1D(e1Loc.x, e1Size.x, e2Loc.x, e2Size.x);
		int distanceY = calDistance1D(e1Loc.y, e1Size.y, e2Loc.y, e2Size.y);
		
		return distanceX + distanceY;
	}
	
	public static int calDistance1D(int e1Left, int e1Length, int e2Left, int e2Length) {
		int distance = e1Left- e2Left;
		if(distance > 0) {
			distance = Math.max(distance - (e2Length - 1), 0);
		} else {
			distance = Math.max(-distance - (e1Length - 1), 0);
		}
		return distance;
	}
}