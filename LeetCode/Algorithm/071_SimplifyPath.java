/*

Given an absolute path for a file (Unix-style), simplify it.

For example,
path = "/home/", => "/home"
path = "/a/./b/../../c/", => "/c"
click to show corner cases.

Corner Cases:
Did you consider the case where path = "/../"?
In this case, you should return "/".
Another corner case is the path might contain multiple slashes '/' together, such as "/home//foo/".
In this case, you should ignore redundant slashes and return "/home/foo".

*/

public class Solution {
    public String simplifyPath(String path) {
        List<String> result = new ArrayList<String>();
        int index = 0;
        while (index < path.length()) {
            if (path.charAt(index) != '/') {
                StringBuilder temp = new StringBuilder();
                while (index < path.length() && path.charAt(index) != '/') {
                    temp.append(path.charAt(index));
                    index++;
                }
                String name = temp.toString();
                if (name.equals("..")) {
                    if (!result.isEmpty()) {
                        result.remove(result.size() - 1);
                    }
                } else if (!name.equals(".")) {
                    result.add(name);
                }
            }
            index++;
        }
        
        if (result.isEmpty()) {
            return "/";
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < result.size(); i++) {
            sb.append('/');
            sb.append(result.get(i));
        }
        return sb.toString();
    }
}