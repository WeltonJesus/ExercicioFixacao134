package entities;

public class Individual extends TaxPayer {
    private Double healthExpenditures;

    public Individual() {
    }


    public Individual(String name, Double anualIncome, Double healthExpenditures) {
        super(name, anualIncome);
        this.healthExpenditures = healthExpenditures;
        //this, estou referenciando a classe em cima
    }

    public Double getHealthExpenditures() {
        return healthExpenditures;
    }

    public void setHealthExpenditures(Double healthExpenditures) {
        this.healthExpenditures = healthExpenditures;
    }

    @Override
    public Double tax() {
        //double basicTax = (getAnualIncome() < 20000.00) ? getAnualIncome() * 0.15 : getAnualIncome() *0.25;
        // poderia fazer assim ? é o então
        // e : é  o senão
        //Tudo isso é operador condicional ternário.


        double basicTax;
        if (getAnualIncome() < 20000.00) {
            basicTax = getAnualIncome() * 15 / 100; //poderia colocar 0.15


        } else {
            basicTax = getAnualIncome() * 25 / 100; // poderia colocar 0.25
        }


        basicTax -= getHealthExpenditures() * 50 / 100; // poderia colocar 0.50
        if (basicTax < 0.0) {
            basicTax = 0.0;
        }
        return basicTax;
    }
}

