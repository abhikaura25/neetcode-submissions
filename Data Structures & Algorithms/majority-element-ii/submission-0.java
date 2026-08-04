class Solution {
    public List<Integer> majorityElement(int[] nums) {

        int candidateA = 0;
        int candidateB = 0;

        int freqA=0;
        int freqB=0;
        
        int n = nums.length;

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
        int countFreqCandidateA = 0;
        int countFreqCandidateB = 0;
        for (int num : nums) {
            if (num == candidateA) {
                countFreqCandidateA++;
            } 

            if (num == candidateB) {
                countFreqCandidateB++;
            }
        }

        if (countFreqCandidateA > (n/3)) {
            resultList.add(candidateA);
        }

        if (countFreqCandidateB > (n/3)) {
            resultList.add(candidateB);
        }

        return resultList;
        
    }
}