public class PostageCalculator {
    public static double calculatePostage(String zipcode1, String zipcode2, double weight, double[] dimensions) {
        double cost = 3.75;
        cost += (weight / 0.1) * 0.05;
        cost += Math.abs(Double.parseDouble(zipcode1.substring(0, 3)) - Double.parseDouble(zipcode2.substring(0, 3))) / 100;
        if (dimensions[0] + dimensions[1] + dimensions[2] > 36) {
            cost += (dimensions[0] + dimensions[1] + dimensions[2]) * 0.1;
        }
        if (weight > 40) {
            cost += (weight - 40) * 0.1;
        }
        return Math.round(cost*Math.pow(10, 2))/Math.pow(10,2);
    }

    public static double calculatePostage(Address origin, Address destination, double weight, double[] dimensions) {
        return calculatePostage(origin.accessData(5), destination.accessData(5), weight, dimensions);
    }

    public static double calculatePostage(Package pack) {
        return calculatePostage(pack.getOrigin().accessData(5), pack.getDestination().accessData(5), pack.getWeight(), pack.getDimensions());
    }
}
