package pjatk.adrwoj.jazs16095nbp.Model;


import java.util.List;

public class Root {
    private String data;
    private double cena;
    public List<Root> prices;


    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    public List<Root> getPrices() {
        return prices;
    }

    public void setPrices(List<Root> prices) {
        this.prices = prices;
    }
}
