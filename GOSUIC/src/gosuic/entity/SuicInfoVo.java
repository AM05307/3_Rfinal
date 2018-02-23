package gosuic.entity;

public class SuicInfoVo {
	
	private int maxPrice;
	private int minPrice;
	private double avgPrice;
	private double maxRate;
	private double minRate;
	private double avgRate;
	
	public int getMaxPrice() {
		return maxPrice;
	}
	public void setMaxPrice(int maxPrice) {
		this.maxPrice = maxPrice;
	}
	public int getMinPrice() {
		return minPrice;
	}
	public void setMinPrice(int minPrice) {
		this.minPrice = minPrice;
	}
	public double getAvgPrice() {
		return avgPrice;
	}
	public void setAvgPrice(double avgPrice) {
		this.avgPrice = avgPrice;
	}
	public double getMaxRate() {
		return maxRate;
	}
	public void setMaxRate(double maxRate) {
		this.maxRate = maxRate;
	}
	public double getMinRate() {
		return minRate;
	}
	public void setMinRate(double minRate) {
		this.minRate = minRate;
	}
	public double getAvgRate() {
		return avgRate;
	}
	public void setAvgRate(double avgRate) {
		this.avgRate = avgRate;
	}
	@Override
	public String toString() {
		return "suicInfoVo [maxPrice=" + maxPrice + ", minPrice=" + minPrice + ", avgPrice=" + avgPrice + ", maxRate="
				+ maxRate + ", minRate=" + minRate + ", avgRate=" + avgRate + "]";
	}
	
	
}
