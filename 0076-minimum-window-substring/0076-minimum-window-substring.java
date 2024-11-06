class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character,Integer> freqMap = new HashMap<>();
    
        for(int i=0;i<t.length();i++){
            char ch = t.charAt(i);
            freqMap.put(ch,freqMap.getOrDefault(ch,0)+1);
        }
        int uniqueCharCount=freqMap.size();
        int startIndex=-1;
        int windowStart=0;
        int windowEnd=0;
        int minLen = Integer.MAX_VALUE;
        int N = s.length();
 
        while(windowEnd<N){
   
            char ch = s.charAt(windowEnd);
            if(freqMap.containsKey(ch)){
                freqMap.put(ch,freqMap.get(ch)-1);
                if(freqMap.get(ch)==0){
                    uniqueCharCount--;
                }
            }
      
            while(uniqueCharCount==0){

                int len = windowEnd-windowStart+1;
                if(len<minLen){
                    minLen = len;
                    startIndex = windowStart;
                }
                ch = s.charAt(windowStart);
                if(freqMap.containsKey(ch)){
                    freqMap.put(ch,freqMap.get(ch)+1);
                    if(freqMap.get(ch)>0){
                        uniqueCharCount++;
                    }
                }
                windowStart++;
            }
            windowEnd++;

        }
        if(startIndex==-1){
            return "";
        }
        return s.substring(startIndex,startIndex+minLen);
    }
}
