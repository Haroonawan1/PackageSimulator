public class Package {
    private Address origin;
    private Address destination;
    private double weight;
    // length, width, height
    private double[] dimensions;

    public Package(Address origin, Address destination, double weight, double[] dimensions) {
        this.origin = origin;
        this.destination = destination;
        this.weight = weight;
        this.dimensions = dimensions;
    }

    public Address getOrigin() {
        return origin;
    }

    public Address getDestination() {
        return destination;
    }

    public double getWeight() {
        return weight;
    }

    public double[] getDimensions() {
        return dimensions;
    }
}
