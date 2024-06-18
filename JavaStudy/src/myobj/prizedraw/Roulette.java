package myobj.prizedraw;

import java.util.Random;

public class Roulette {

	public Prize[] prizes;
	Random ran = new Random();
	
	public Roulette() {
		prizes = new Prize[10];
	}
	
	public void addPrize(Prize prize) {
		for (int i = 0; i < prizes.length; i++) {
			if (prizes[i] == null) {
				prizes[i] = prize;
				return;
			}
		}
	}
	
	// 당첨 확률 조정
	public void winProbability(String prizeName, double newProbability) {
		for (Prize prize : prizes) {
			if (prize != null && prize.getName().equals(prizeName)) {
				prize.setwinProbability(newProbability);
				return;
			}
		}
	}
	
	// 룰렛 돌리기
	public Roulette spin() {
		double totalProbability = 0;
		for (Prize prize : prizes) {
			if (prize != null) {
				totalProbability += prize.getwinProbability();
			}
		}
		
		double ranValue = ran.nextDouble() * totalProbability;
		
		return spin();
	}
}
