package produktionscode;


//Author Marcel Blasius
public class State implements IF_State{

    private Double GesamtEinnahmen;
    private Double AvgEinnahmen;
    private Double AvgParkdauer;
    private Integer Besucheranzahl;
    private Double MinEinnahmen;
    private Double MinParkdauer;
    private Double MaxEinnahmen;
    private Double MaxParkdauer;


    public Double getAvgEinnahmen() {
        return AvgEinnahmen;
    }
    public void setAvgEinnahmen(Double avgEinnahmen) {
        AvgEinnahmen = avgEinnahmen;
    }
    public Double getGesamtEinnahmen() {
        return GesamtEinnahmen;
    }
    public void setGesamtEinnahmen(Double gesamtEinnahmen) {
        GesamtEinnahmen = gesamtEinnahmen;
    }
    public Double getAvgParkdauer() {
        return AvgParkdauer;
    }
    public void setAvgParkdauer(Double avgParkdauer) {
        AvgParkdauer = avgParkdauer;
    }
    public Integer getBesucheranzahl() {
        return Besucheranzahl;
    }
    public void setBesucheranzahl(Integer besucheranzahl) {
        Besucheranzahl = besucheranzahl;
    }
    public Double getMinEinnahmen() {
        return MinEinnahmen;
    }
    public void setMinEinnahmen(Double minEinnahmen) {
        MinEinnahmen = minEinnahmen;
    }
    public Double getMinParkdauer() {
        return MinParkdauer;
    }
    public void setMinParkdauer(Double minParkdauer) {
        MinParkdauer = minParkdauer;
    }
    public Double getMaxEinnahmen() {
        return MaxEinnahmen;
    }
    public void setMaxEinnahmen(Double maxEinnahmen) {
        MaxEinnahmen = maxEinnahmen;
    }
    public Double getMaxParkdauer() {
        return MaxParkdauer;
    }
    public void setMaxParkdauer(Double maxParkdauer) {
        MaxParkdauer = maxParkdauer;
    }


}