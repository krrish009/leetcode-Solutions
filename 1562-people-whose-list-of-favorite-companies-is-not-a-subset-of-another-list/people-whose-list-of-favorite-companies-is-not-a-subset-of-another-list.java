class Solution {
    public List<Integer> peopleIndexes(List<List<String>> favoriteCompanies) {
        List<Integer> ans = new ArrayList<>();
        int n = favoriteCompanies.size();
        
        List<Set<String>> companySets = new ArrayList<>();
        for (List<String> companies : favoriteCompanies) {
            companySets.add(new HashSet<>(companies));
        }

        for(int i = 0; i < n; i++){
            boolean isSubset = false;
            for(int j = 0; j < n; j++){
                if(i == j) continue;

                if(companySets.get(j).containsAll(companySets.get(i))){
                    isSubset = true;
                    break;
                }
            }
            if(!isSubset){
                ans.add(i);
            }
        }
        return ans;
    }
}