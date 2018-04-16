package com.javarush.task.task21.task2104;

import java.util.HashSet;
import java.util.Set;

/* 
Equals and HashCode
*/
public class Solution {
    private final String first, last;

    public Solution(String first, String last) {
        this.first = first;
        this.last = last;
    }

    public boolean equals(Object n) {
        if(n == null) {
            return false;
        }
        if(!(n instanceof Solution)) {
            return false;
        }
//        return n.first.equals(first) && n.last.equals(last);
        if(this == n) {
            return true;
        }
//        if(((Solution) n).first != null && ((Solution) n).first.equals(this.first)) {
//            return true;
//        }
//        if(((Solution) n).last != null && ((Solution) n).last.equals(last)) {
//            return true;
//        }
        Solution sol = (Solution) n;
        if (first != null ? !first.equals(sol.first) : sol.first != null) return false;
        if (last != null ? !last.equals(sol.last) : sol.last != null) return false;

        return true;
    }

    public int hashCode() {
        int result = this.first != null ? first.hashCode() : 0;
//        System.out.println(31 * first.hashCode() + last.hashCode());
//        return 31 * first.hashCode() + last.hashCode();
        result = 31 * result + (this.last != null ? last.hashCode() : 0);
//        System.out.println(result);
        return result;
    }

    public static void main(String[] args) {
        Set<Solution> s = new HashSet<>();
        s.add(new Solution("Donald", "Duck"));
        System.out.println(s.contains(new Solution("Donald", "Duck")));
    }
}
