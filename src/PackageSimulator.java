import java.util.ArrayList;

public class PackageSimulator {
    private ArrayList<Package> packages;

    public PackageSimulator() {
        packages = new ArrayList<>();
    }

    public void generatePackages(int amount) {
        for (int i = 0; i < amount; i++) {
            String addressStr1 = "123=Random Street=Apt 3C=City=State=" + ((int) (Math.random() * 99450) + 501);
            String addressStr2 = "123=Random Street=Apt 3C=City=State=" + ((int) (Math.random() * 99450) + 501);
            double weight = Math.random() * 70;
            double[] dimensions = new double[]{Math.random() * 25, Math.random() * 25, Math.random() * 25};

            packages.add(new Package(new Address(addressStr1), new Address(addressStr2), weight, dimensions));
        }
    }

    public double generateTotalCost() {
        double totalCost = 0.0;
        for (Package pack : packages) {
            totalCost += PostageCalculator.calculatePostage(pack);
        }
        return Math.round(totalCost*Math.pow(10, 2))/Math.pow(10,2);
    }

    public String getSimulationInfo() {
        String result = "Randomly generated package's info:";
        for (int i = 0; i < packages.size(); i++) {
            result += "\nPackage " + (i + 1) + ": ____________________________________________\n";
            result += "Origin Address: " + packages.get(i).getOrigin() + "\n";
            result += "Destination Address: " + packages.get(i).getDestination() + "\n";
            result += "Weight: " + packages.get(i).getWeight() + "\n";
            result += "Length: " + packages.get(i).getDimensions()[0] + "\n";
            result += "Width: " + packages.get(i).getDimensions()[1] + "\n";
            result += "Height: " + packages.get(i).getDimensions()[2] + "\n";
            result += "Cost: " + PostageCalculator.calculatePostage(packages.get(i));
        }
        result += "\n_______________________________________________________\nTotal Cost of all packages: " + generateTotalCost();
        resetSimulation();
        return result;
    }

    public void resetSimulation() {
        packages = new ArrayList<>();
    }
}
