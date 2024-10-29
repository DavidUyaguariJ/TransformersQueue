package transformers;

public class Transformer {
    private String name;
    private String faction;
    private double power;
    private String function;

    public Transformer() {
        this.name = "Bumblebee";
        this.faction = "Decepticon";
        this.power = 3;
        this.function ="Guerrero";
    }
    /**
     * @param power {double} permite mostrar el poder, tipo double para poder generar los aumentos de poder
     * */
    public Transformer(String name, String faction, double power, String function) {
        this.name = name;
        this.faction = faction;
        this.power = power;
        this.function = function;
    }

    public String getFaction() {
        return faction;
    }

    public double getPower() {
        return power;
    }

    public void setFaction(String faction) {
        this.faction = faction;
    }

    public void setPower(double power) {
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
