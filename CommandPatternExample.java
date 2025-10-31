interface Command {
    void execute();
}

class Light {
    void turnOn() { System.out.println("Light is ON"); }
    void turnOff() { System.out.println("Light is OFF"); }
}

class TurnOnLightCommand implements Command {
    private final Light light;
    public TurnOnLightCommand(Light light) { this.light = light; }
    public void execute() { light.turnOn(); }
}

class TurnOffLightCommand implements Command {
    private final Light light;
    public TurnOffLightCommand(Light light) { this.light = light; }
    public void execute() { light.turnOff(); }
}

class RemoteControl {
    private Command command;
    public void setCommand(Command command) { this.command = command; }
    public void pressButton() { command.execute(); }

    public static void main(String[] args) {
        Light light = new Light();
        Command on = new TurnOnLightCommand(light);
        Command off = new TurnOffLightCommand(light);
        RemoteControl remote = new RemoteControl();
        remote.setCommand(on);
        remote.pressButton();
        remote.setCommand(off);
        remote.pressButton();
    }
}