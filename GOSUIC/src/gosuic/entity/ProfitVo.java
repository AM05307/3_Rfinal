package gosuic.entity;

public class ProfitVo {
	private double maxProfit;
	private double minProfit;
	private double avgProfit;
	
	public double getMaxProfit() {
		return maxProfit;
	}
	public void setMaxProfit(double maxProfit) {
		this.maxProfit = maxProfit;
	}
	public double getMinProfit() {
		return minProfit;
	}
	public void setMinProfit(double minProfit) {
		this.minProfit = minProfit;
	}
	public double getAvgProfit() {
		return avgProfit;
	}
	public void setAvgProfit(double avgProfit) {
		this.avgProfit = avgProfit;
	}
	@Override
	public String toString() {
		return "SuicVo [maxProfit=" + maxProfit + ", minProfit=" + minProfit + ", avgProfit=" + avgProfit + "]";
	}
	
}
	
