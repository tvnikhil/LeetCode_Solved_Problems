// { Driver Code Starts
#include<bits/stdc++.h>
using namespace std;


 // } Driver Code Ends
class Solution{
    public:
        
    // A[]: input array
    // N: size of array
    // Function to find the maximum index difference.
    int maxIndexDiff(int A[], int N) 
    { 
        // Your code here
        int res = -1;
        for (int i = 0; i < N; i++) {
            int farthestRight = i;
            // for (int j = i; j < N; j++) {
            //     if (A[j] >= A[i])
            //         farthestRight = j;
            // }
            for (int j = N-1; j >= i; j--) {
                if (A[j] >= A[i]) {
                    farthestRight = j;
                    break;
                }
            }
            res = max(res, farthestRight-i);
        }
        return res;
    }
};

// { Driver Code Starts.
  
/* Driver program to test above functions */
int main() 
{
    int T;
    //testcases
    cin>>T;
    while(T--){
        int num;
        //size of array
        cin>>num;
        int arr[num];
        
        //inserting elements
        for (int i = 0; i<num; i++)
            cin>>arr[i];
        Solution ob;
        
        //calling maxIndexDiff() function
        cout<<ob.maxIndexDiff(arr, num)<<endl;    
        
    }
    return 0;
}   // } Driver Code Ends