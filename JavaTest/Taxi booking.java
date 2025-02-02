import java.util.*;

class Taxi {
    static int idCounter = 1;
    int id;
    char currentLocation;
    int earnings;
    int availableTime;

    public Taxi() {
        this.id = idCounter++;
        this.currentLocation = 'A';
        this.earnings = 0;
        this.availableTime = 0;
    }

    public void assignRide(char pickup, char drop, int pickupTime) {
        int distance = Math.abs(drop - pickup) * 15;
        int fare = 100 + Math.max(0, (distance - 5) * 10);
        this.earnings += fare;
        this.currentLocation = drop;
        this.availableTime = pickupTime + (Math.abs(drop - pickup) * 60);
        System.out.println("Taxi " + id + " assigned. Fare: Rs." + fare);
    }
}

class TaxiService {
    List<Taxi> taxis;

    public TaxiService(int numTaxis) {
        taxis = new ArrayList<>();
        for (int i = 0; i < numTaxis; i++) {
            taxis.add(new Taxi());
        }
    }

    public void bookTaxi(char pickup, char drop, int pickupTime) {
        Taxi selectedTaxi = null;
        int minDistance = Integer.MAX_VALUE;
        int minEarnings = Integer.MAX_VALUE;

        for (Taxi taxi : taxis) {
            int taxiDistance = Math.abs(taxi.currentLocation - pickup);
            if (taxi.availableTime <= pickupTime && taxiDistance <= minDistance) {
                if (taxiDistance < minDistance || taxi.earnings < minEarnings) {
                    minDistance = taxiDistance;
                    minEarnings = taxi.earnings;
                    selectedTaxi = taxi;
                }
            }
        }

        if (selectedTaxi != null) {
            selectedTaxi.assignRide(pickup, drop, pickupTime);
        } else {
            System.out.println("No taxi available at this time.");
        }
    }
}

public class CallTaxiBookingApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TaxiService service = new TaxiService(4);

        while (true) {
            System.out.println("Enter booking details (Pickup, Drop, Time) or Q to quit:");
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("Q")) break;
            
            String[] details = input.split(" ");
            char pickup = details[0].charAt(0);
            char drop = details[1].charAt(0);
            int time = Integer.parseInt(details[2]);
            
            service.bookTaxi(pickup, drop, time);
        }
        scanner.close();
    }
}
