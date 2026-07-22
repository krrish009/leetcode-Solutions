import java.util.*;

class Solution {
    private Map<String, Integer> distMap = new HashMap<>();
    private List<List<String>> result = new ArrayList<>();
    private String start;

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) {
            return result;
        }

        this.start = beginWord;

        // Step 1: Run BFS from beginWord to construct minimum distance map
        bfs(beginWord, wordSet);

        // Step 2: If endWord was reached, backtrack using DFS from endWord to beginWord
        if (distMap.containsKey(endWord)) {
            List<String> path = new ArrayList<>();
            path.add(endWord);
            dfs(endWord, path);
        }

        return result;
    }

    // Step 1: BFS to find the shortest distance from beginWord to every word
    private void bfs(String beginWord, Set<String> wordSet) {
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        distMap.put(beginWord, 0);

        while (!queue.isEmpty()) {
            String word = queue.poll();
            int currentDist = distMap.get(word);

            char[] chars = word.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                char original = chars[i];
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    if (ch == original) continue;
                    chars[i] = ch;
                    String nextWord = new String(chars);

                    if (wordSet.contains(nextWord)) {
                        // If nextWord is visited for the first time
                        if (!distMap.containsKey(nextWord)) {
                            distMap.put(nextWord, currentDist + 1);
                            queue.add(nextWord);
                        }
                    }
                }
                chars[i] = original; // Backtrack character
            }
        }
    }

    // Step 2: DFS to backtrack all shortest paths from endWord back to beginWord
    private void dfs(String word, List<String> path) {
        if (word.equals(start)) {
            // Reverse path to convert (endWord -> beginWord) to (beginWord -> endWord)
            List<String> validPath = new ArrayList<>(path);
            Collections.reverse(validPath);
            result.add(validPath);
            return;
        }

        int currentDist = distMap.get(word);

        char[] chars = word.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char original = chars[i];
            for (char ch = 'a'; ch <= 'z'; ch++) {
                if (ch == original) continue;
                chars[i] = ch;
                String nextWord = new String(chars);

                // Only move to neighbor if its distance is exactly currentDist - 1
                if (distMap.containsKey(nextWord) && distMap.get(nextWord) == currentDist - 1) {
                    path.add(nextWord);
                    dfs(nextWord, path);
                    path.remove(path.size() - 1); // Backtrack path
                }
            }
            chars[i] = original; // Backtrack character
        }
    }
}