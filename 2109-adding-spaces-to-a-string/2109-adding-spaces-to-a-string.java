class Solution {
    public String addSpaces(String s, int[] spaces) {
        int n=s.length();
        int m=spaces.length;
        char[] newChrs=new char[n+m];
        char[] sChr=s.toCharArray();

        int i=0;
        int idx=0;
        for(int spc:spaces){
            while(i<spc){                
                newChrs[idx++]=sChr[i];
                i++;                
            }   
            newChrs[idx++]=' ';
        }
        while(i<n){                
            newChrs[idx++]=sChr[i];
            i++;                
        }   
        return new String(newChrs);
    }
}