class Solution {
    public int calPoints(String[] operations) {
        ArrayList<Integer> arr = new ArrayList<>();
        int top = 0;
        for (int i = 0; i < operations.length; i++) {
            if (operations[i].equals("C")) {
                arr.remove(top - 1);
                top--;
            } 
            else if (operations[i].equals("D")) {
                arr.add(2 * arr.get(top - 1));
                top++;
            }
            else if (operations[i].equals("+")) {
                arr.add(arr.get(top - 1) + arr.get(top - 2));
                top++;
            } else {
                arr.add(Integer.parseInt(operations[i]));
                top++;
            }
            System.out.println(arr);
            System.out.print(top);
        }
        
        return sum(arr);
    }
    
    int sum(ArrayList<Integer> a) {
        int added = 0;
        for (int num : a) 
            added += num;      
        return added;
    }
    
    
}
