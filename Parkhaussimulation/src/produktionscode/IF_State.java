package produktionscode;

public interface IF_State {
	
	public Double getGesamtEinnahmen();
	public Double getAvgEinnahmen();
	public Double getAvgParkdauer();
	public Double getBesucheranzahl();
	public Double getMinEinnahmen();
	public Double getMinParkdauer();
	public Double getMaxEinnahmen();
	public Double getMaxParkdauer();
	
	public void setGesamtEinnahmen(Double gesamtEinnahmen);
	public void setAvgEinnahmen(Double avgEinnahmen);
	public void setAvgParkdauer(Double avgParkdauer);
	public void setBesucheranzahl(Double besucheranzahl);
	public void setMinEinnahmen(Double minEinnahmen);
	public void setMinParkdauer(Double minParkdauer);
	public void setMaxEinnahmen(Double maxEinnahmen);
	public void setMaxParkdauer(Double maxParkdauer);
	
	
	
}
