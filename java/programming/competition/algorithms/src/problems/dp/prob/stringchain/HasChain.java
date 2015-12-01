package problems.dp.prob.stringchain;
import java.util.*;
 
class HasChain {
 
    Map<Character, List<String>> startsWithStringMap = new HashMap<Character, List<String>>();
    Map<Character, List<String>> endsWithStringMap = new HashMap<Character, List<String>>();
 
    private Character getFirstChar(String str) {
        return str.charAt(0);
    }
 
    private Character getLastChar(String str) {
        return str.charAt(str.length() - 1);
    }
 
    boolean hasChain(List<String> stringList) {
        // create relations between strings and their first
        // and last characters using two hasmaps. 
        for (String str : stringList) {
            Character start = getFirstChar(str);
            Character end = getLastChar(str);
            List<String> startsWithList;
            List<String> endsWithList;
 
            if (startsWithStringMap.containsKey(start)) {
                startsWithList = startsWithStringMap.get(start);
            } else {
                startsWithList = new ArrayList<String>();
                startsWithStringMap.put(start, startsWithList);
            }
 
            if (endsWithStringMap.containsKey(end)) {
                endsWithList = endsWithStringMap.get(end);
            } else {
                endsWithList = new ArrayList<String>();
                endsWithStringMap.put(end, endsWithList);
            }
            startsWithList.add(str);
            endsWithList.add(str);
        }
 
        // this stack is the solution stack
        Stack<String> stringStack = new Stack<String>();
        for (String str : stringList) {
            if (hasChain(stringList.size(), str, stringStack)) {
                System.out.println(stringStack);
 
                return true;
            }
        }
 
        return false;
    }
 
    // recursively iterates through all possibilities
    private boolean hasChain(int size, String startString, Stack<String> stringStack) {
        if (size == stringStack.size()) return true; // if the stack is full of strings, we found it!
        Character last = getLastChar(startString);
        if (startsWithStringMap.containsKey(last)) {
            List<String> stringList = startsWithStringMap.get(last);
            for (int i = 0; i < stringList.size(); i++) {
                String candidate = stringList.remove(i--); // remove the candidate as it shouldn't be used in the next iterations
                stringStack.push(candidate); // as if it is the solution
                if (hasChain(size, candidate, stringStack)) {
                    return true; // no need to continue
                }
                stringStack.pop(); // candidate is not the solution
                stringList.add(++i, candidate); // put it back to the list, where it belongs
            }
        }
 
        return false;
    }
 
    public static void main(String[] args) {
        List<String> stringList = new ArrayList<String>();
        
        stringList.add("aaszx");
        stringList.add("prtws");
        stringList.add("stuia");
        
        /*stringList.add("bd");
        stringList.add("fk");
        stringList.add("ab");
        stringList.add("kl");
        stringList.add("cf");
        stringList.add("ff");
        stringList.add("fa");
        stringList.add("ak");
        stringList.add("ka");
        stringList.add("lf");
        stringList.add("bc");*/
        
        System.out.println(stringList);
 
        System.out.println(new HasChain().hasChain(stringList)); // should return true as there is a solution
 
        /*stringList.remove("ka"); // we break the chain here
 
        System.out.println(new HasChain().hasChain(stringList));*/  // should return false as there is no solution after removing 'ka'
 
    }
}