class Solution {
    public List<Integer> majorityElement(int[] nums) {

        int candidateA = 0;
        int candidateB = 0;

        int freqA=0;
        int freqB=0;

        List<Integer> resultList = new ArrayList<Integer>();

        for (int num: nums) {
            if (num == candidateA) {
                freqA++;
            } else if (num == candidateB) {
                freqB++;
            } else if (freqA == 0) {
                candidateA = num;
                freqA++;
            } else if (freqB == 0) {
                candidateB = num;
                freqB++;
            } else {
                freqA--;
                freqB--;
            }
        }

        //validity check
        freqA = 0;
        freqB = 0;
        for (int num : nums) {
            if (num == candidateA) {
                freqA++;
            } 

            if (num == candidateB) {
                freqB++;
            }
        }

        int n = nums.length/3;

        if (freqA > n) {
            resultList.add(candidateA);
        }

        if (freqB > n) {
            resultList.add(candidateB);
        }

        return resultList;
        
    }
}