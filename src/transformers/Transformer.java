package transformers;

public class Transformer {
    private String name;
    private String faction;
    private int power;
    private String function;

    public Transformer() {
        this.name = "Bumblebee";
        this.faction = "Autobot";
        this.power = 3;
        this.function ="Guerrero";
    }

    public Transformer(String nombre, String faction, int power, String function) {
        this.name = nombre;
        this.faction = faction;
        this.power = power;
        this.function = function;
    }

    public String getFaction() {
        return faction;
    }

    public int getPower() {
        return power;
    }

    public void setFaction(String faction) {
        this.faction = faction;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function;
    }

    @Override
    public String toString(){
        return "Name: "+name +" Faction: "+ faction + " Power:"+ power+" Function:"+function;
    }
}
