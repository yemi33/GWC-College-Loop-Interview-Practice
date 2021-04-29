class Solution {
    public void reverseString(char[] s) {
        /*
        s = ["h","e","l","l","o"]
              l.              r
              swap(l, r)
        s = ["o","e","l","l","h"] 
                  l.      r
                  swap(l, r)
        s = ["o","l","l","e","h"]    
                      lr
        */
        int l = 0;
        int r = s.length - 1;
        
        while (l < r) {
            swap(l,r,s);
            l++;
            r--;
        }
    }
    
    public void swap(int l, int r, char[] s) {
        char temp = s[l];
        s[l] = s[r];
        s[r] = temp;
    }
}
