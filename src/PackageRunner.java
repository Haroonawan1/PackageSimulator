import java.util.Scanner;

public class PackageRunner {
    public static void main(String[] args) {
        PackageSimulator packageSimulator = new PackageSimulator();
        Scanner s = new Scanner(System.in);
        String input = "0";

        while(!input.equals("4")) {
            System.out.print("_______________________________________________________\nWhat would you like to do?\n1. Calculate cost of one package\n2. Simulate packages\n3. How package costs are calculated\n4. Exit\nInput: ");
            input = s.nextLine();

            if (input.equals("1")) {
                System.out.println("_______________________________________________________");
                String[] prompts = new String[]{"Enter the zip code of the origin package: ", "Enter the zip code of the destination package: ", "Enter the weight of the package: ", "Enter the height of the package: ", "Enter the length of the package: ", "Enter the width of the package: "};
                String[] inputs = new String[6];
                for (int i = 0; i < 6; i++) {
                    System.out.print(prompts[i]);
                    inputs[i] = s.nextLine();
                }
                System.out.println("Cost: " + PostageCalculator.calculatePostage(inputs[0], inputs[1], Double.parseDouble(inputs[2]), new double[]{Double.parseDouble(inputs[3]), Double.parseDouble(inputs[4]), Double.parseDouble(inputs[5])}));
            }
            if (input.equals("2")) {
                System.out.print("_______________________________________________________\nHow many packages would you like to simulate? ");
                int amount = Integer.parseInt(s.nextLine());
                packageSimulator.generatePackages(amount);
                System.out.println(packageSimulator.getSimulationInfo());
            }
            if (input.equals("3")) {
                System.out.println("_______________________________________________________\nFormula for the cost of shipping:\n - A base cost of $3.75\n - Add 5 cents for each tenth of a pound\n - Divide the difference in county codes by 100 and add that\n - Packages exceeding a combined 36 inches will cost an additional 10 cents per inch\n - Packages that are more than 40 pounds will be charged 10 cents per tenth of a pound over the 40 pound limit");
            }
        }
    }
}
