// { Driver Code Starts
//Initial Template for C++

#include <bits/stdc++.h>
#include <string>

using namespace std;


 // } Driver Code Ends
//User function Template for C++

class Solution
{
    public:
    vector<string> ans;
    map<int, string> keyPad;
    void formPosString(int a[], int N, string t, int idx, map<int, string> &keyPad)
    {
        if (idx == N) {
            ans.push_back(t);
            return;
        }
        int digit = a[idx], len = keyPad[digit].size();
        for (int i = 0; i < len; i++)
            formPosString(a, N, t + keyPad[digit][i], idx+1, keyPad);
    }
    //Function to find list of all words possible by pressing given numbers.
    vector<string> possibleWords(int a[], int N)
    {
        //Your code here
        keyPad[2] = "abc";
        keyPad[3] = "def";
        keyPad[4] = "ghi";
        keyPad[5] = "jkl";
        keyPad[6] = "mno";
        keyPad[7] = "pqrs";
        keyPad[8] = "tuv";
        keyPad[9] = "wxyz";
        formPosString(a, N, "", 0, keyPad);
        return ans;
    }
};


// { Driver Code Starts.

int main() {
  
	int T;
	
	cin >> T; //testcases
	
	while(T--){ //while testcases exist
	   int N;
	    
	   cin >> N; //input size of array
	   
	   int a[N]; //declare the array
	   
	   for(int i =0;i<N;i++){
	       cin >> a[i]; //input the elements of array that are keys to be pressed
	   }
	   
	   Solution obj;
	   
	  vector <string> res = obj.possibleWords(a,N);
	  for (string i : res) cout << i << " ";
	   cout << endl;
	}
	
	return 0;
}  // } Driver Code Ends