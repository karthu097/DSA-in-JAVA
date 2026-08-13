class Solution {
    public boolean backspaceCompare(String s, String t) {
        int i = s.length() - 1;
        int j = t.length() -1;

        int SkipS =0; // the counters
        int SkipT=0;//counters\
        while(i>=0 ||j>=0){
        while(i>=0){
            if(s.charAt(i) == '#'){
                SkipS++; // collects the data how many number of the hashs there in  the string 
                i--; // it is a pointer which moves towards  lefts and traverses the array 
            }else if(SkipS>0){
                SkipS--; //this removes the elements that are beside of #
                i--; // pointer which moves towards left 
            }else{
                break;
            }

        }
        while(j>=0){
            if(t.charAt(j) == '#'){
                SkipT++;
                j--;
            }else if(SkipT>0){
                SkipT--;
                j--;
            }else{
                break;
            }
        }
       // Compare valid characters
            if (i >= 0 && j >= 0) {
                if (s.charAt(i) != t.charAt(j)) {
                    return false;
                }

                i--;
                j--;
            }

            // One string has a character while the other doesn't
            else if (i >= 0 || j >= 0) {
                return false;
            }
        }
            return true;
        }

   
}