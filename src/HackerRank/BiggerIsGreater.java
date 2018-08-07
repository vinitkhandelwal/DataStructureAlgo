package HackerRank;

/**
 * Lexicographical order is often known as alphabetical order when dealing with strings. A string is greater than another string if it comes later in a lexicographically sorted list.
 *
 * Given a word, create a new word by swapping some or all of its characters. This new word must meet two criteria:
 *
 * It must be greater than the original word
 * It must be the smallest word that meets the first condition
 * For example, given the word , the next largest word is .
 *
 * Complete the function biggerIsGreater below to create and return the new string meeting the criteria. If it is not possible, return no answer.
 *
 * Function Description
 *
 * Complete the biggerIsGreater function in the editor below. It should return the smallest lexicographically higher string possible from the given string or no answer.
 *
 * biggerIsGreater has the following parameter(s):
 *
 * w: a string
 * Input Format
 *
 * The first line of input contains , the number of test cases.
 * Each of the next  lines contains .
 */

public class BiggerIsGreater {

    public static void main(String[] args) {

        BiggerIsGreater biggerIsGreater = new BiggerIsGreater();
        System.out.println(biggerIsGreater.biggerIsGreater("bb"));

    }


    /**
     * Idea is very simple here :
     * 1. Find the largest index i such that array[i-1] < array[i];
     * 2. Find the largest index j such that array[j] >= array[i-1] && j > i
     * 3. Swap j and i-1 element
     * 4. Reverse the suffix string starting at array[i]
     * Source : https://www.nayuki.io/page/next-lexicographical-permutation-algorithm
     * @param input
     * @return
     */
    public String biggerIsGreater(String input){

        char [] array = input.toCharArray();

        // Find longest non-increasing suffix
        int i = array.length -1;
        while(i > 0 && array[i-1] >= array[i]){
            i--;
        }
        // Now i is the head index of the suffix

        if(i <= 0){
            return "No Answer";
        }

        // Let array[i - 1] be the pivot
        // Find rightmost element that exceeds the pivot
        int j = array.length -1;
        while(j > 0 && array[j] <= array[i-1]){
            j--;
        }

        //swap the pivot with j
        int temp = array[i-1];
        array[i-1] = array[j];
        array[j] = (char) temp;

        // Reverse the suffix
        j = array.length - 1;
        while (i < j) {
            temp = array[i];
            array[i] = array[j];
            array[j] = (char) temp;
            i++;
            j--;
        }

        return new String(array);

    }
}
