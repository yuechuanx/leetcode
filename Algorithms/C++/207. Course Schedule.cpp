class Solution {
public:
    bool canFinish(int numCourses, vector<pair<int, int>>& prerequisites) {
        vector<int> res;  // 构造返回值
        vector<vector<int>> graph(numCourses, vector<int>(0));  // 利用输入构造有向图
        vector<int> in(numCourses, 0);  // 有向图定点的入度数组
        // 每一个pair对，是一条 pair.second 指向 pair.first 的边
        for(auto &a: prerequisites) {
            graph[a.second].push_back(a.first);
            ++in[a.first];
        }
        queue<int> q;
        for(int i = 0; i < numCourses; ++i) {
            if(in[i] == 0) q.push(i);
        }
        while(!q.empty()) {
            int t = q.front();
            res.push_back(t);
            q.pop();
            for(auto &a: graph[t]) {  // 根据领接表，遍历 t 所指向的顶点，这些顶点的入度-1
                --in[a];
                if(in[a] == 0) q.push(a);
            }
        }
        for (int i = 0; i < numCourses; ++i) {
            if (in[i] != 0) return false;
        }
        return true;
    }
};
