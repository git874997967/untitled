import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Array_Hash_String {
    /**/

    /**
     * 例题 1 Determine if all characters of a string are unique.
     * 判断一个字符串所有的字符是否都是唯一的。
     *
     * @param a get param string from outside
     *          chars convert string to a array of chars
     *          charMap store char and index into a map
     * @return boolean result
     * @author zhenming
     * @date
     */
    public static void uniqueChar(String a) {
        boolean result = true;
        Map charMap = new HashMap();
        char[] chars = a.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            //not contain the value add it
            if (!charMap.containsValue(chars[i])) {
                charMap.put(i, chars[i]);
            } else {
                result = false;
            }
        }
        System.out.println(result);
    }

    /**
     * 例 题 2 Given two strings, determine if they are
     * permutations of each other
     *
     * @param a get string from outside
     * @param b get string  from outside
     *          receive two strings convert to charArray and sort with Array.sort()first
     *          then we can get two order array and get HashMap from each of them to tell
     */
    public static void isPermutation(String a, String b) {
        boolean result = true;
        // convert to the charArray
        char[] array_a = a.toCharArray();
        char[] array_b = b.toCharArray();
        Map charMap_a = new HashMap();
        Map charMap_b = new HashMap();
        // if the length diff result is false
        if (array_a.length != array_b.length) {
            result = false;
        } else {
            Arrays.sort(array_a);
            Arrays.sort(array_b);
            for (int i = 0; i < array_a.length; i++) {
                charMap_a.put(i, array_a[i]);
                charMap_b.put(i, array_b[i]);
            }
            if (!charMap_a.equals(charMap_b)) {
                result = false;
            }

        }

        System.out.println(result);
    }

    /**
     * 例题 3 Given a newspaper and message as two strings,
     * check if the message can be composed using letters in the
     * newspaper
     *
     * @param a newspaper  material to construct the message
     * @param b the message to be constructed
     *          condition 1  newspaper is shorter
     *          2   length is ok but without some chars
     *          3 with some chars but not enough.
     */


    public static void composString(String a, String b) {
        boolean result = true;
        char[] char_a = a.toCharArray();
        char[] char_b = b.toCharArray();
        //newspaper is shorter than message impossable
        if (char_a.length < char_b.length) {
            System.out.println("too short");
            result = false;
        } else {
            //this is wrong I only consider appear once instead of all of them.
           /* Map map_b = new HashMap();
            Set set_b=new HashSet();
            for (int i = 0; i < char_b.length; i++) {
                map_b.put(i, char_b[i]);

            }
            for (int j = 0; j < char_a.length; j++) {
                if (!map_b.containsValue(char_a[j])) {
                    result = false;
                }
            }*/
            // build the map key is the char value is the times
            Map map_a = new HashMap();
            for (int i = 0; i < char_a.length; i++) {
                if (!map_a.containsKey(char_a[i])) {
                    map_a.put(char_a[i], i);
                } else {
                    int new_value = (int) map_a.get(char_a[i]);
                    map_a.replace(char_a[i], new_value + 1);
                }
            }
            /* check the char a in map b or not*/
            for (int j = 0; j < char_b.length; j++) {
                // if not in map  return false
                if (!map_a.containsKey(char_b[j])) {
                    System.out.println("not in here");
                    result = false;
                    break;
                } else {
                    int new_value = (int) map_a.get(char_a[j]) - 1;
                    map_a.replace(char_a[j], new_value);
                    if (new_value < 0) {
                        result = false;
                        System.out.println("not enough");
                        break;
                    }

                }
            }
        }
        System.out.println(result);
    }

    /**
     * 例题 4 Find a pair of two elements in an array, whose sum
     * is a given target number. Assume only one qualified pair of
     * numbers existed in the array, return the index of these
     * numbers (e.g. returns (i, j), smaller index in the front)
     *
     * @param arrs
     * @param result
     */
    public static void twoElements(int[] arrs, int result) {
        Map map = new HashMap();
        int larger_index = 0;
        int smaller_index = 0;
        int smaller_value = 0;
        for (int i = 0; i < arrs.length; i++) {
            map.put(arrs[i], result - arrs[i]);
            //we find it value is smaller and key is larger
            // record the value
            if (map.containsValue(arrs[i])) {
                larger_index = i;
                break;
            }
        }
        smaller_value = result - arrs[larger_index];
        for (int j = 0; j < arrs.length; j++) {
            if (arrs[j] == smaller_value) {
                smaller_index = j;
                break;
            }
        }
        System.out.println("index are " + smaller_index + " and " + larger_index);
    }

    /**
     * 例题 5 Get the length of the longest consecutive elements
     * sequence in an array. For example, given [31, 6, 32, 1, 3,
     * 2],the longest consecutive elements sequence is [1, 2, 3].
     * Return its length: 3.
     *
     * @param arr
     */
    public static void longestSequence(int[] arr) {
        Arrays.sort(arr);
        int max_length[] = new int[arr.length];
        int length = 0;
        max_length[1] = 1;
        for (int i = 0; i < arr.length; i++) {

            if (i < arr.length - 1) {
                if (arr[i] == arr[i + 1] - 1) {
                    max_length[i + 1] = max_length[i] + 1;
                }
            } else {
                if (arr[i] == arr[i - 1] + 1) {
                    max_length[i] = max_length[i - 1] + 1;
                }
            }

            System.out.println(max_length[i] + " " + arr[i]);
        }
        Arrays.sort(max_length);
        length = max_length[max_length.length - 1] + 1;

        System.out.println("the longest consecutive elements sequences is " + length);
    }

    public static void main(String[] args) {
      /*  String a = "ab!c b";
        String b = "abcvbcvbca";
        String c = "anb!dbchj !";
        String d = "!bcba ";
        String e = "abcvbcvbcd";*/
  /*     uniqueChar(a);
       uniqueChar(b);
       uniqueChar(c);*/
       /* isPermutation(b, e);
        isPermutation(a, d);*/
        //composString("abccccccd", "abbcdb");
        int[] arrs = {31, 6, 0, 4, 32, 1, 3, 2};
        int result = 9;
        // twoElements(arrs, result);
        longestSequence(arrs);
    }
}
