class Solution {
    class DSU {
        int parent[];
        int size[];
        int N;
        
        DSU(int N) {
            this.N = N;
            this.parent = new int[N];
            this.size = new int[N];

            for (int i = 0; i < N; i++) {
                this.parent[i] = i;
                this.size[i] = 1;
            }
        }

        int findParent(int a) {
            if (parent[a] == a) {
                return a;
            }
            int ultimateParent = findParent(parent[a]);
            parent[a] = ultimateParent;
            return ultimateParent;
        }

        void union(int a, int b) {
           int ultimateParentA = findParent(a);
           int ultimateParentB = findParent(b);

           if (ultimateParentA == ultimateParentB) {
               return; // There is nothing to be done same set.
           }
           
           if (size[ultimateParentA] >= size[ultimateParentB]) {
                parent[ultimateParentB] = ultimateParentA;
                size[ultimateParentA] += size[ultimateParentB];
           } else {
                
                parent[ultimateParentA] = ultimateParentB;
                size[ultimateParentB] += size[ultimateParentA];
            
           }
        }
    }
    
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        DSU dsu = new DSU(n);
        
        // Map to correlate emails to their first-seen account index
        Map<String, Integer> emailToIdx = new HashMap<>();

        for(int i = 0; i < n; i++){
            List<String> account = accounts.get(i);
            for(int j = 1; j < account.size(); j++){
                String email = account.get(j);
                if(emailToIdx.containsKey(email)){
                    dsu.union(i,emailToIdx.get(email));
                } else {
                    emailToIdx.put(email, i);
                }
            }
        }

        // Step 2: Group emails under their ultimate root indices
        Map<Integer, List<String>> rootToEmails = new HashMap<>();
        for(String email : emailToIdx.keySet()){
            int rootParent = dsu.findParent(emailToIdx.get(email));
            if(!rootToEmails.containsKey(rootParent)){
                rootToEmails.put(rootParent,new ArrayList<>());
            }
            rootToEmails.get(rootParent).add(email);
        }

        // Step 3: Package final results sorted alphabetically
        List<List<String>> mergedAccounts = new ArrayList<>();
        for (int rootIdx : rootToEmails.keySet()){
            List<String> emails = rootToEmails.get(rootIdx);
            Collections.sort(emails);
            List<String> account = new ArrayList<>();
            account.add(accounts.get(rootIdx).get(0));
            account.addAll(emails);
            
            mergedAccounts.add(account);
        }
        return mergedAccounts;
    }
}
