package calc.operation;

public class Multiplier {
    private int mult;
    public Multiplier() {
        mult = 1;
    }

    public Multiplier(int a) {
        mult = a;
    }

    public void multiply(int n){
        this.mult *= n;
    }

    public int getMult(){
        return this.mult;
    }






}
