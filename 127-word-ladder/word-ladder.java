class Solution {
    class pair{
        String word;
        int steps;
        pair(String w,int s){
            this.word=w;
            this.steps=s;
        }
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<pair> q=new LinkedList<>();
        q.add(new pair(beginWord,1));
        HashSet<String> set=new HashSet<>(wordList);
        set.remove(beginWord);

        while(!q.isEmpty()){
            pair front=q.poll();
            String word=front.word;
            int steps=front.steps;
            if(word.equals(endWord)==true) return steps;

            char[] ReplacedCharArray = word.toCharArray();
            for(int i=0;i<word.length();i++){
                char OrignalChar=ReplacedCharArray[i];
                for(char ch='a'; ch<='z'; ch++){
                    ReplacedCharArray[i]=ch;
                    String ReplacedWord=new String(ReplacedCharArray);

                    if(set.contains(ReplacedWord)){
                        set.remove(ReplacedWord);
                        q.add(new pair(ReplacedWord,steps+1));
                    }
                }
                ReplacedCharArray[i]=OrignalChar;
            }
        }
    return 0;
    }
}