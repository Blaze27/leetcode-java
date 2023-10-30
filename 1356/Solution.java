class Solution {
    public int[] sortByBits(int[] arr) {
        Arrays.sort(arr);
        Map<Integer,ArrayList<Integer>> map = new TreeMap<>();
        for (int i = 0; i < arr.length; i++) {
            int count = 0;
            int num = arr[i];
            for (int j = 0; j < 32; j++) {
                if (((1 << j) & num) != 0) {
                    count += 1;
                }
            }
            // System.out.println("The number of Bits in "+ num + " is " + count);
            if (map.containsKey(count)) {
                map.get(count).add(num);
            }
            else {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(num);
                map.put(count, list);
            }
        }
        int[] ans = new int[arr.length];
        int i = 0;
        for(Map.Entry m:map.entrySet()){    
            ArrayList<Integer> s = (ArrayList<Integer>)m.getValue();
            for (int j = 0; j < s.size(); j++, i++) {
                ans[i] = s.get(j);
            }
        }

        return ans;   
    }
}
