package utilidades;

import java.awt.geom.Point2D;
import java.util.*;

public class CoordenadaUtil {

    private Point2D myPosition;
    private Map<Point2D, CoordenadaUtil> neighborLinks;

    public class NearestComparator implements Comparator<Map.Entry> {

        @Override
        public int compare(Map.Entry e1, Map.Entry e2) {
            return Double.compare((Double) e1.getValue(), (Double) e2.getValue());
        }
    }

    public List<Point2D> getSendOrder(Point2D destination) {
        LinkedList<Map.Entry> sendOrderList = new LinkedList<>();
        Map.Entry<Point2D, Double> pointWithDist;

        // calculate distance from destination and wrap it using an Entry
        pointWithDist = new AbstractMap.SimpleEntry<>(myPosition, myPosition.distance(destination));
        sendOrderList.add(pointWithDist);
        for (Point2D otherPoint : neighborLinks.keySet()) {
            pointWithDist = new AbstractMap.SimpleEntry<>(otherPoint, otherPoint.distance(destination));
            sendOrderList.add(pointWithDist);
        }

        // sort list by distance from destination
        Collections.sort(sendOrderList, new NearestComparator());

        // print all the list (debug)
        System.out.println(Arrays.toString(sendOrderList.toArray()));

        // unwrap and deep copy
        LinkedList<Point2D> copiedList = new LinkedList<>();
        Point2D pointToCopy, copiedPoint;
        for (Map.Entry entry : sendOrderList) {
            pointToCopy = (Point2D) entry.getKey();
            copiedPoint = new Point2D.Double(pointToCopy.getX(), pointToCopy.getY());
            copiedList.add(copiedPoint);
        }

        return copiedList;
    }

    public CoordenadaUtil(Point2D myPosition, Map<Point2D, CoordenadaUtil> neighborLinks) {
        this.myPosition = myPosition;
        this.neighborLinks = neighborLinks;
    }
}
