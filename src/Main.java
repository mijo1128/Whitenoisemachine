import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        NoiseMachine machine = new NoiseMachine();
        Scanner input = new Scanner(System.in);
        boolean running = true;

        while(running){
            machine.printMachineStatus();
            System.out.println("[POWER] on/off switch, [S] to change noise, [S,POWER] to lock, [VOL-], [VOL+], " +
                    "[POWERPOWER] to turn night light on, or [Q] to quit ");
            System.out.print(">> ");

            String choice = input.nextLine().toUpperCase();
            if(!machine.isLocked && machine.isOn) {
                switch (choice) {
                    case "POWER" -> machine.powerSwitch();
                    case "S,POWER" -> machine.lockMachine();
                    case "S" -> machine.changeNoise();
                    case "VOL+", "VOL-" -> machine.changeVolume(choice);
                    case "POWERPOWER" -> machine.setNightLight();
                    default -> System.out.println("Please select from the provided buttons");

                }
            }else if(choice.equals("Q")){
                System.out.println("Noise machine has been unplugged, effectively killing it.");
                running = false;
            } else if(choice.equals("S,POWER") && machine.isOn){
                machine.lockMachine();
            } else if (choice.equals("POWER") && !machine.isOn){
                machine.powerSwitch();
            }else {System.out.println("Please unlock or turn machine ON machine before selecting a button.\n");
            }
        }

    }
}