public class LC134_GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalSurplus = 0;
        int currentSurplus = 0;
        int startStation = 0;

        for (int i = 0; i < gas.length; i++) {
            int net = gas[i] - cost[i];
            totalSurplus += net;
            currentSurplus += net;

            if (currentSurplus < 0) {
                // Cannot reach station i + 1 from any station between startStation and i
                startStation = i + 1;
                currentSurplus = 0;
            }
        }

        return totalSurplus >= 0 ? startStation : -1;
    }
}
