import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.lang.reflect.Array;
import java.time.Duration;
import java.util.*;
import java.util.stream.Collectors;

public class Test {

    public static void main(String[] args){
//        int[][] grid = {{9,9,8,1},{5,6,2,6},{8,2,6,4},{6,2,2,2}};
//        int len = grid.length;
//        int[][] result = new int[len-2][len-2];
////        System.out.println(len);
//        for(int i=0;i<len-2;i++){
//            for(int j=0; j<len-2; j++) {
//                int max = cal(len, grid, i,j);
//                System.out.println(max);
//                result[i][j] = max;
//            }
//        }

        //String Palindrome
//        boolean flag = isPalindrome("madam");
//        System.out.println("Result = "+flag);

//        pracStream();

//        makeSmallestPalindrome("seven");

//        multiSelectDropDown();

//        int[] arr1 = {1,2,4,0,6,0};
//        int[] arr2 = {0,0,2,4,0,9};
//        int[] arr3 = {0,0,0,0,0,0};
//        int[] arr4 = {1,2,3,7,8,9,5};
////        sortArray(arr1);
//        sortArray(arr2);
//        sortArray(arr3);
//        sortArray(arr4);

//        System.out.println(clearDigitsNew("abc"));
//        System.out.println(clearDigitsNew("cb34"));
//        System.out.println(clearDigitsNew("c"));
//        System.out.println(clearDigitsNew("b4y6"));
//        System.out.println(clearDigitsNew("j4y8y"));

//        convertUpperToLower("AnkiT");

//        removeOrPrintaChar();

//        int[] input1 = {1,4,5,7,9,9,7,5};
//        int[] input2 = {10, 20, 5, 25, 21};
////        getSecondLargestNumber(input2);
//
//        getNthLargestNumber(input1, 5);

//        firstNonRepeatChar("abcdab");
//        lastFourChar("abcsdrdfgfd");
//        System.out.println("result - "+findRepeatElement("abcdadbcabcd"));
//        int[] arr1 = {10,11,5,6,9,3,10,2};
//        findMaxDiffInArr(arr1);

//        int[] arr1 = {-1,3,4,-2,4,-2,1,1,-4,9};
//        int[] arr2 = {-1,-9,-2,-5};
//        moveNegativeNumAtStart(arr1);
//        moveNegative(arr1);
//        moveNegativeInline(arr1);
//        moveNegativeInlineWithoutList(arr1);

        reverseWord();
    }

    //Reverse each word present in sentence
    public static void reverseWord(){
        String str = "my name is Ankit";
        String[] arr = str.split(" ");
        StringBuffer result = new StringBuffer();
        for(String word : arr){

            StringBuffer s = new StringBuffer();
            result.append(s.append(word).reverse());
            result.append(" ");
        }
        System.out.println(result);
    }

    public static void moveNegativeInlineWithoutList(int[] arr){
        int j=0;
        for(int i=0; i<arr.length; i++){
            if(arr[i] < 0){
                int temp = arr[i];

                for(int k=i-1; k>=j; k--){
                    int t = arr[k];
                    arr[k+1] = arr[k];
                    arr[k] = t;
                }
                arr[j] = temp;
                j++;
                i = j-1;
            }
        }
        System.out.println("Array "+Arrays.toString(arr));

    }

    //inline movement using arrayList
    public static void moveNegativeInline(int[] arr){
        List<Integer> li = Arrays.stream(arr).boxed().collect(Collectors.toList());

        int j=0;
        for(int i=0; i<li.size(); i++){
            if(li.get(i)<0){
                int temp = li.get(i);
                li.remove(i);
                li.add(j, temp);
                j++;
                i = j-1;
            }
        }
        System.out.println("Array "+li);

    }

    //move negative number at start of array
    public static void moveNegative(int[] arr){
        int j=0;
        for(int i=0; i<arr.length; i++){
            if(arr[i]<0){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                j++;
                System.out.println("Array "+Arrays.toString(arr));
                System.out.println("---");
            }
        }
        System.out.println("Array "+Arrays.toString(arr));

    }


    //move negative number at start of array
    public static void moveNegativeNumAtStart(int[] arr){
        int[] result = new int[arr.length];
        int index = 0;
        for(int i=0; i<arr.length; i++){
            if(arr[i]<0){
                result[index] = arr[i];
                index++;
            }
        }

        for(int i=0; i<arr.length; i++){
            if(arr[i]>0){
                result[index] = arr[i];
                index++;
            }
        }

        System.out.println("result "+Arrays.toString(result));


        int firstPosIndex = -1;
        for(int i=0; i<arr.length; i++){
            if(arr[i]>0){
                firstPosIndex = i;
                break;
            }
        }

        for(int i=0; i<arr.length; i++){
            if(arr[i]<0 && i!=0){
                int temp = arr[i];
                arr[i] = arr[firstPosIndex];
                arr[firstPosIndex] = temp;
                firstPosIndex++;
            }
        }
        System.out.println("result "+Arrays.toString(arr));

    }


    //Find maximum difference
    public static void findMaxDiffInArr(int[] arr){
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for(int i=0; i<arr.length; i++){
            if(arr[i]>max){
                max = arr[i];
            }
            if(arr[i]<min){
                min = arr[i];
            }
        }

        System.out.println("min "+min+ " max "+max);
        int result = max-min;
        System.out.println(result);
    }

    //find repeating element from string
    public static String findRepeatElement(String input){
        StringBuffer result = new StringBuffer();
        Set<Character> set = new HashSet<>();
        Set<Character> repeatCharUnique = new HashSet<>();
        for(char ch : input.toCharArray()){
            if(!set.add(ch)){
                result.append(ch);
                repeatCharUnique.add(ch);
            }
        }
        System.out.println(repeatCharUnique);
        return result.toString();
    }

    public static String lastFourChar(String str){
        StringBuffer result = new StringBuffer();
        int count = 0;

        for(int i=str.length()-1; i>=0; i--){
            result.append(str.charAt(i));
            if(count == 3){
                break;
            }
            count++;
        }
        System.out.println(result);
        return result.toString();
    }

    public static void firstNonRepeatChar(String str){
        str = str.toLowerCase();
        int[] arr = new int[27];

        for(char ch : str.toCharArray()){
            arr[ch - 'a']++ ;
        }
        char result = '1';
        for(char ch : str.toCharArray()){
            if(arr[ch-'a'] == 1){
                result = ch;
                break;
            }
        }
        System.out.println(Arrays.toString(arr));
        System.out.println("result "+result);
    }

    public static void getNthLargestNumber(int[] num, int n){
        if(n>num.length){
            System.out.println("out of range");
            return;
        }

        ArrayList<Integer> a = Arrays.stream(num).boxed().collect(Collectors.toCollection(ArrayList :: new));

        int largestNumber = Integer.MIN_VALUE;
        int result = 0;
        int index = 0;
        while(index != n){
            int tempIndex = 0;

            for(int i=0; i<a.size(); i++){
                if(a.get(i)>largestNumber ){
                    largestNumber = a.get(i);
                    tempIndex = i;
                }
            }
            result = a.get(tempIndex);
//            a.remove(tempIndex);
            int finalResult = result;
            a.removeIf(val -> val == finalResult);
            while(a.contains(result)){
                a.remove(a.indexOf(result));
            }
            System.out.println("List "+a);

            index++;
            largestNumber = Integer.MIN_VALUE;
//            System.out.println("Arr "+Arrays.toString(arr));
        }
        System.out.println("Result "+result);
    }

    public static void getSecondLargestNumber(int[] num){
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;
        for(int n : num){
            if(n>largest){
                secondLargest = largest;
                largest = n;
            }else if(n>secondLargest && n!=largest){
                secondLargest = n;
            }
        }
        System.out.println(largest);
        System.out.println(secondLargest);
    }

    public static void removeOrPrintaChar(){
        String name = "Ankit";
        StringBuffer str = new StringBuffer(name);
        int index = name.indexOf('n');
        str = str.deleteCharAt(index);
        System.out.println(str);
    }

    public static void convertUpperToLower(String str){
        StringBuffer result = new StringBuffer();
        for(char ch : str.toCharArray()){

            if(ch>='A' && ch<='Z'){
                 ch = (char)  (ch+32);
            }
            result.append(ch);


//            if(Character.isUpperCase(ch)){
//                result.append(Character.toLowerCase(ch));
//            }else{
//                result.append(ch);
//            }
        }
        System.out.println(result);
    }

    public static String clearDigitsNew(String s) {

        Stack<Character> stack = new Stack<>();
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(Character.isAlphabetic(ch)){
                stack.add(ch);
            } else if (Character.isDigit(ch)) {
                if(!stack.isEmpty()){
                    stack.pop();
                }
            }
        }
//        StringBuffer str = new StringBuffer();
//        stack.stream().forEach(x->str.append(x));
        return stack.toString();
    }

    public static String clearDigits(String s) {
        if(s.length() == 1){
            return s;
        }
        StringBuffer str = new StringBuffer(s);
        int i=0;
        int j=1;
        boolean flag = true;
        while(flag){
            boolean leftVal = Character.isDigit(str.charAt(i));
            boolean rightVal = Character.isDigit(str.charAt(j));
            if(rightVal){
                if(!leftVal){
                    str.deleteCharAt(i);
                    str.deleteCharAt(i);
                }
            }
            i++;
            j++;
            if(rightVal && !leftVal){
                i=0;
                j=1;
            }
            if(j>=str.length()){
                flag = false;
            }
        }
        return  str.toString();
    }

    public static void sortArray(int[] arr){
        boolean flag = true;
        int i=0;
        int j = 1;
        while(flag){
            if(arr[i] !=0 && arr[j] !=0){
                i++;
                j++;
            }
            else if (arr[i] == 0)
            {
                if(arr[j] == 0){
                    j++;
                }
            }
            else{
                arr[i] = arr[j];
                arr[j] = 0;
            }
        }
//        System.out.println(Arrays.toString(arr));

    }

    public static void sortArray_old(int[] arr){
        int[] result = new int[arr.length];
        int count = 0;
        for(int i=0; i<arr.length; i++){
            if(arr[i] != 0){
                result[count] = arr[i];
                count++;
            }
        }

        System.out.println(Arrays.toString(result));
    }

    public static void multiSelectDropDown(){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://coreui.io/bootstrap/docs/forms/multi-select/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        JavascriptExecutor js = (JavascriptExecutor) driver;
//
        By dropDownClick = By.xpath("//select[@class='form-multi-select' and @id='ms1']//parent::div");
//        By dropDown = By.xpath("//select[@class='form-multi-select' and @id='ms1']//parent::div//div[contains(@class, 'form-multi-select-buttons')]");
//        WebElement ele = wait.until(ExpectedConditions.elementToBeClickable(dropDown));

        WebElement eleClick = wait.until(ExpectedConditions.elementToBeClickable(dropDownClick));
        js.executeScript("arguments[0].scrollIntoView(true);",eleClick);

        By selectD = By.xpath("(//input[@class='form-multi-select-search' and @placeholder='Select...'])[1]");
        WebElement selectEl = driver.findElement(selectD);
        js.executeScript("arguments[0].click();",selectEl);
        System.out.println("class "+selectEl.getDomAttribute("class"));
        By dropDownBy = By.xpath("//select[@class='form-multi-select' and @id='ms1']//parent::div//div[@class='form-multi-select-options']//div[@tabindex]");
        List<WebElement> dropDownEl = driver.findElements(dropDownBy);
        System.out.println(dropDownEl.size());

        for(WebElement element : dropDownEl){
            System.out.println(element.getText());
            if(element.getText().equalsIgnoreCase("Angular") || element.getText().equalsIgnoreCase("Django")){
                js.executeScript("arguments[0].click();",element);
            }
        }


//        eleClick.click();

    }

    public static String makeSmallestPalindrome(String s) {
        int start = 0;
        int end = s.length()-1;
        StringBuffer str = new StringBuffer(s);
        for(int i=0; i<s.length()/2; i++){
            if(str.charAt(start) != str.charAt(end)){
                if(str.charAt(start) >  str.charAt(end)){
                    str.setCharAt(start,str.charAt(end));
                }else{
                    str.setCharAt(end,str.charAt(start));
                }
            }
            start++;
            end--;
            System.out.println(str);
            System.out.println("---");
        }
        return str.toString();
    }

    public static void pracStream(){
        List<String> li = new ArrayList<>();


        li.add("ankit");
        li.add("dhey");
        li.add("laptop");
        li.add("garima");
        li.add("app");
        li.add("laptop");

        boolean flag = li.stream().filter(x -> x.equalsIgnoreCase("app")).findFirst().isPresent();
        System.out.println("flag = "+flag);

        String index = li.stream().filter(x -> x.contains("app")).findAny().orElseThrow(() -> new RuntimeException("not found"));
        System.out.println("index = "+index);
    }

    //Remove Leading zeros
    public static int removeLeadingZero(int num){
        int result = 0;


        return result;
    }

    public static boolean isPalindrome(String str){
        boolean flag = false;
        char[] strArr = str.toCharArray();
        if(strArr[0] != strArr[strArr.length-1]){
            return false;
        }

        StringBuffer resultStr = new StringBuffer();
        for(int i = strArr.length-1; i>=0; i--){
            resultStr.append(strArr[i]);
        }
        System.out.println(str+" "+resultStr);
        if(resultStr.toString().equals(str)){
            flag = true;
        }
        return flag;
    }

    public static int cal(int len, int[][] grid, int indexI, int indexJ){
        int num = 0;
        for(int i=indexI; i<(indexI+3); i++){
            for(int j=indexJ; j<(indexJ+3); j++){
//                System.out.println(grid[i][j]);
                num = Math.max(num, grid[i][j]);

            }
            System.out.println("----");
        }
        return num;
    }

}