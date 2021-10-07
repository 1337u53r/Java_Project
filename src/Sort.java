public class Sort extends Main {

    Functions functions = new Functions();

    public void selectSortType() {

        String sortUserInput;

        System.out.println("Enter numbers you wish to sort (each followed by commas)");
        String arrayInput = functions.getRawInputString();

        while (arrayInput.matches(".*[a-z].*")) {

            System.out.println("List must not alphabetic characters");
            System.out.println("Enter numbers you wish to sort (each followed by commas)");
            arrayInput = functions.getRawInputString();

        }

        int[] arrayList = functions.convertToIntegerArray(arrayInput);

        System.out.println(" __________________________ ");
        System.out.println("|       |[SORT MENU]|      |");
        System.out.println("|                          |");
        System.out.println("| OPTIONS:                 |");
        System.out.println("|         [A] Insertion    |");
        System.out.println("|         [B] Bubble       |");
        System.out.println("|         [C] Selection    |");
        System.out.println("|__________________________| ");
        System.out.print(">> ");
        sortUserInput = functions.getRawInputString();
        sortUserInput = sortUserInput.toUpperCase();

        switch (sortUserInput) {
            case "A":
                System.out.println("Insertion Sort Result:");
                insertionSort(arrayList);
                printArray(arrayList);
                break;

            case "B":
                System.out.println("Bubble Sort Result:");
                bubbleSort(arrayList);
                printArray(arrayList);
                break;

            case "C":
                System.out.println("Selection Sort Result:");
                selectionSort(arrayList);
                printArray(arrayList);
                break;

            default:
                System.out.println("Invalid Selection");
                break;

        }
    }

    public void insertionSort(int arrayList[]) {
        int arrayLength = arrayList.length;

        for (int index=1; index<arrayLength; ++index) {
            int unsortedElement = arrayList[index];
            int sortedElement = index-1;

            while (sortedElement>=0 && arrayList[sortedElement] > unsortedElement) {
                arrayList[sortedElement+1] = arrayList[sortedElement];
                sortedElement = sortedElement-1;
            }

            arrayList[sortedElement+1] = unsortedElement;
        }
    }

    public void bubbleSort(int arrayList[]) {
        int arrayLength = arrayList.length;

        for (int index = 0; index < arrayLength-1; index++)

            for (int currentElement = 0; currentElement < arrayLength-index-1; currentElement++)

                if (arrayList[currentElement] > arrayList[currentElement+1]) {
                    // Swap arrayList[index] and tempVar
                    int tempVar = arrayList[currentElement];
                    arrayList[currentElement] = arrayList[currentElement+1];
                    arrayList[currentElement+1] = tempVar;
                }
    }

    public void selectionSort(int arrayList[]) {
        int arrayLength = arrayList.length;

        // One by one move boundary of unsorted subarray
        for (int index = 0; index < arrayLength-1; index++) {
            // Find the minimum element in unsorted array
            int minElement = index;
            for (int nextElement = index+1; nextElement < arrayLength; nextElement++)
                if (arrayList[nextElement] < arrayList[minElement])
                    minElement = nextElement;

            int tempVar = arrayList[minElement];
            arrayList[minElement] = arrayList[index];
            arrayList[index] = tempVar;
        }
    }


    public void printArray(int arrayList[]) {
        int arrayLength = arrayList.length;
        for (int index=0; index<arrayLength; ++index)
            System.out.print(arrayList[index] + " ");

        System.out.println();
        functions.continueOrExit();
    }


}
