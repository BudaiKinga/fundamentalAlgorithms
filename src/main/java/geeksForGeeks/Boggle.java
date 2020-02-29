package geeksForGeeks;

import java.util.*;

public class Boggle {
    private final String[] dictionary;
    private final char[][] map;
    private boolean[][] visited;
    private Trie trie;
    private static String word;

    public Boggle(String[] dictionary, char[][] map) {
        this.dictionary = dictionary;
        this.map = map;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nrTests = sc.nextInt();
        for (int i = 0; i < nrTests; i++) {
            int dicSize = sc.nextInt();
            String[] dictionary = new String[dicSize];
            for (int j = 0; j < dicSize; j++) {
                dictionary[j] = sc.next();
            }
            int dimx = sc.nextInt();
            int dimy = sc.nextInt();
            char[][] map = new char[dimx][dimy];
            for (int j = 0; j < dimx; j++) {
                for (int k = 0; k < dimy; k++) {
                    map[j][k] = sc.next().charAt(0);
                }
            }
            // String line = sc.next();
            Boggle b = new Boggle(dictionary, map);
            b.solve();
        }
    }

    private void solve() {
        buildTreeFromDictionary();
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                Queue<BoggleChar> charactersToCheck = new LinkedList<>();
                initVisited();
                charactersToCheck.add(new BoggleChar(map[i][j], i, j));
                trie.initForSearch();
                visited[i][j] = true;
                word = "";
                while (!charactersToCheck.isEmpty()) {
                    BoggleChar currentBoggleChar = charactersToCheck.poll();
                    if (trie.hasCharacter(currentBoggleChar.c)) {
                        word += currentBoggleChar.c;
                        List<BoggleChar> neighbors = getNeighbors(currentBoggleChar.i, currentBoggleChar.j);
                        charactersToCheck.addAll(neighbors);
                    }
                }
            }
        }
    }

    private class BoggleChar {
        char c;
        int i, j;

        public BoggleChar(char c, int i, int j) {
            this.c = c;
            this.i = i;
            this.j = j;
        }
    }

    private List<BoggleChar> getNeighbors(int i, int j) {
        List<BoggleChar> neighbs = new LinkedList<>();
        int starti = Math.max(i - 1, 0);
        int startj = Math.max(j - 1, 0);
        int endi = Math.min(map.length-1, i + 1);
        int endj = Math.min(map.length-1, j + 1);

        for (int k = starti; k <= endi; k++) {
            for (int l = startj; l <= endj; l++) {
                if (!visited[l][k]) {
                    neighbs.add(new BoggleChar(map[l][k], l, k));
                }
            }
        }
        return neighbs;
    }

    private void initVisited() {
        visited = new boolean[map.length][map.length];
    }

    private void buildTreeFromDictionary() {
        Arrays.sort(dictionary);
        trie = new Trie();
        for (String word : dictionary) {
            trie.addWord(word);
        }
    }

    private static class Node {
        char c;
        List<Node> children;

        public Node(char currentChar) {
            this.c = currentChar;
            this.children = new ArrayList<>();
        }
    }

    private static class Trie {
        private static final Node WORD_EXISTS_SENTINEL = new Node('*');

        List<Node> nodes = new ArrayList<>();
        List<Node> currentNodes;

        public void addWord(String word) {
            if (word == null || word.isEmpty()) {
                return;
            }
            List<Node> currentNodes = nodes;
            Node matchedNode = null;
            for (int i = 0; i < word.length(); i++) {
                char currentChar = word.charAt(i);
                matchedNode = null;
                for (Node n : currentNodes) {
                    if (n.c == currentChar) {
                        matchedNode = n;
                    }
                }
                if (matchedNode == null) {
                    matchedNode = new Node(currentChar);
                    currentNodes.add(matchedNode);
                }
                currentNodes = matchedNode.children;
            }
            matchedNode.children.add(WORD_EXISTS_SENTINEL);
        }

        public boolean hasCharacter(char c) {
            for (Node n : currentNodes) {
                if (n.c == c) {
                    currentNodes = n.children;
                    if (isCompleteWordFound(currentNodes)) {
                        System.out.println("Found: " + word + c);
                    }
                    return true;
                }
            }
            return false;
        }

        private boolean isCompleteWordFound(List<Node> currentNodes) {
            return currentNodes.contains(WORD_EXISTS_SENTINEL);
        }

        public void initForSearch() {
            currentNodes = nodes;
        }
    }
}
