class Solution {
public:
    int maximumGroups(vector<int>& grades) {
        if (grades.size()==1)
            return 1;
        if (grades.size()==2 && grades[0] == grades[1])
            return 1;
        int count = 0, i = grades.size();
        for (int grpsize = 1; i > 0; grpsize++) {
            if (grpsize > i)
                break;
            i -= grpsize;
            count++;
        }
        return count;
    }
};