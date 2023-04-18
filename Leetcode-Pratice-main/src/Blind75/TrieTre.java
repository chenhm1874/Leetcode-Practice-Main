package Blind75;

public class TrieTre {
    class TrieNode{
        public boolean is_word;
        public TrieNode[] children;
        public TrieNode(){
            children=new TrieNode[26];
            is_word=false;
        }
    }
    private TrieNode root;
    public void Trie(){
        root = new TrieNode();
    }
    public void insert(String word){
        TrieNode p=root;
        int index=0;
        for(int i=0;i<word.length();i++){
            index=(int)word.charAt(i)-'a';
            if(p.children[index]==null){
                p.children[index]=new TrieNode();
            }
            p=p.children[index];
        }
        p.is_word=true;
    }
    public boolean search(String word){
        if(word==null){
            return false;
        }
        TrieNode p=root;
        int index=0;
        for(int i=0;i<word.length();i++){
            index=(int)word.charAt(i)-'a';
            if(p.children[index]==null){
                return false;
            }
        }
        return false;
    }
}

