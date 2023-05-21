public class NoiseMachine {
    public boolean isOn = false;
    public boolean isLocked = false;
    public String nightLight = "OFF";
    public int volume = 50;

    public String noise = "BRIGHT";


    public void powerSwitch(){
        if(!this.isOn){
            this.isOn = true;
            this.volume = 50;
            this.noise = "BRIGHT";
            this.nightLight = "OFF";
        } else {
            this.isOn = false;
        }
    }
    public void changeNoise() {
        switch(this.noise){
            case "BRIGHT" -> this.noise = "DEEP";
            case "DEEP" -> this.noise = "GENTLE";
            case "GENTLE" -> this.noise = "BRIGHT";
        }
    }

    public void changeVolume(String choice) {
        switch (choice) {
            case "VOL+" -> {
                if (this.volume + 10 < 100) {
                    this.volume += 10;
                } else {
                    this.volume = 100;
                }
            }
            case "VOL-" -> {
                if (this.volume - 10 > 0) {
                    this.volume -= 10;
                } else {
                    this.volume = 0;
                }
            }
        }
    }

    public void lockMachine(){
        if(!this.isLocked){
            this.isLocked = true;
        } else {
            this.isLocked = false;
        }
    }

    public void setNightLight(){
        if(this.nightLight.equals("OFF")) {
            this.nightLight = "ON";
        } else if (this.nightLight.equals("ON")) {
            this.nightLight = "OFF";
        }
    }

    public void printMachineStatus(){
        if(!this.isOn) {
            System.out.println("Machine status: OFF");
            System.out.println();
        } else {
            System.out.println("Machine Status: ON");
            if (!this.isLocked) {
                System.out.println("Lock Status: UNLOCKED");
            } else {System.out.println("Lock Status: LOCKED");}
            System.out.println("Current noise: " + this.noise);
            System.out.println("Volume: " + this.volume);
            System.out.println("Night Light: " + this.nightLight);
            System.out.println();
        }
    }


}
