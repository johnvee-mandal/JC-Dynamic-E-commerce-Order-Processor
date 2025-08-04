import java.util.Scanner;

public class InteractiveOrderProcessor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

    
        System.out.println("Welcome to the Interactive Order Processor!");
        System.out.println("\n--- Enter Order Details ---");

        System.out.print("Enter unit price: ");
        double unitPrice = scanner.nextDouble();

        System.out.print("Enter quantity: ");
        int quantity = scanner.nextInt();

        System.out.print("Is customer a member (true/false)?: ");
        boolean isMember = scanner.nextBoolean();

        scanner.nextLine(); 
        System.out.print("Enter customer tier (Regular, Silver, Gold): ");
        String customerTier = scanner.nextLine();

        System.out.print("Enter shipping zone (ZoneA, ZoneB, ZoneC, Unknown): ");
        String shippingZone = scanner.nextLine();

        System.out.print("Enter discount code (SAVE10, FREESHIP, or \"\" for none): ");
        String discountCode = scanner.nextLine();

       
        System.out.println("\n--- Order Details ---");
        System.out.printf("Unit Price: $%.2f\n", unitPrice);
        System.out.println("Quantity: " + quantity);
        System.out.println("Is Member: " + isMember);
        System.out.println("Customer Tier: " + customerTier);
        System.out.println("Shipping Zone: " + shippingZone);
        System.out.println("Discount Code: " + discountCode);

        System.out.println("\n--- Calculation Steps ---");

        double subTotal = unitPrice * quantity;
        System.out.printf("Initial Subtotal: $%.2f\n", subTotal);

        double total = subTotal;
        if (customerTier.equals("Gold")) {
            total *= 0.85; 
            System.out.printf("After Tier Discount (Gold - 15%%): $%.2f\n", total);
        } else if (customerTier.equals("Silver")) {
            total *= 0.90; 
            System.out.printf("After Tier Discount (Silver - 10%%): $%.2f\n", total);
        } else {
            System.out.println("After Tier Discount (No discount): $" + total);
        }

        if (quantity >= 5) {
            total *= 0.95; 
            System.out.printf("After Quantity Discount (5%% for >=5 items): $%.2f\n", total);
        }

        boolean freeShippingApplied = false;
        if (discountCode.equals("SAVE10") && total > 75.00) {
            total -= 10.00;
            System.out.printf("After Promotional Code (SAVE10 for >$75): $%.2f\n", total);
        } else if (discountCode.equalsIgnoreCase("FREESHIP")) {
            freeShippingApplied = true;
            System.out.printf("After Promotional Code (FREESHIP): $%.2f\n", total);
        }

        double surcharge = total < 25.00 ? 3.00 : 0.00;
        total += surcharge;
        System.out.printf("After Small Order Surcharge (if applicable): $%.2f (%s)\n", total, surcharge > 0 ? "$3.00 surcharge applied" : "No surcharge");

        double shippingCost = 0.00;
        if (!freeShippingApplied) {
            switch (shippingZone) {
                case "ZoneA":
                    shippingCost = 5.00;
                    break;
                case "ZoneB":
                    shippingCost = 12.50;
                    break;
                case "ZoneC":
                    shippingCost = 20.00;
                    break;
                default:
                    shippingCost = 25.00;
                    break;
            }
        }

        System.out.printf("\nShipping Cost: $%.2f (%s)\n", shippingCost, freeShippingApplied ? "FREESHIP Applied" : shippingZone);

        double finalOrderTotal = total + shippingCost;
        System.out.printf("\nFinal Order Total: $%.2f\n", finalOrderTotal);

        System.out.println("\n--- String Equality Demo ---");
        System.out.print("Enter first string for comparison: ");
        String str1 = scanner.nextLine();

        System.out.print("Enter second string for comparison: ");
        String str2 = scanner.nextLine();

        System.out.println("\nString 1: \"" + str1 + "\"");
        System.out.println("String 2: \"" + str2 + "\"");

        System.out.println("\nString 1 == String 2: " + (str1 == str2));
        System.out.println("String 1 .equals() String 2: " + str1.equals(str2));
        System.out.println("String 1 .equalsIgnoreCase() String 2: " + str1.equalsIgnoreCase(str2));

        System.out.println("\nNote: '==' compares references, .equals() compares contents, .equalsIgnoreCase() ignores case differences.");

        scanner.close();
    }
}
