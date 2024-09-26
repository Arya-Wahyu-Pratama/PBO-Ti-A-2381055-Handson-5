import java.util.Scanner;
public class Main {
    public static String[] todos = new String[10];
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        addTodoList("Membaca");
        addTodoList("Makan");
        addTodoList("Menggambar");
        showTableTodo();
        removeTodoList(2);
        System.out.println("After remove");
        showTableTodo();
    }
    public static void showTableTodo() {
        System.out.pritln("Todo List");
        for (int i = 0; i < todos.length; i++) {
            String todo = todos[i];
            if(todos[i] != null) {
                System.out.println((i + 1) + ". " + todo);
            }
        }
    }
    public static void addTodoList (String todo) {
        boolean isFull = isArrayFull();

        for (int i = 0; i < todos.length; i++){
            if(todos[i] == null){
                todos[i] = todo;
                break;
            }
        }
    }
    public static void resizeArrayIfFull() {
        boolean isFull = isArrayFull();
    }
    private static void resizeArrayToTwoTimesBigger() {
            String[] temp = todos;
            todos = new String(todos.length * 2);
            for(int i = 0; i < temp.length; i++){
                todos[i] = temp[i];
            }
        }
    private static boolean isArrayFull() {
        boolean isFull = true;
        for (int i = 0; i < todos.length; i++) {
            if (todos[i] == null) {
                isFull = false;
                break;
            }
        }
        return isFull;
    }
    public static boolean removeTodoList ( Integer number){
        if (isSelectorTodoNotValid(number)) return false;
        for (int i = number-1; i < todos.length;i++){
            if(i == (todos.length -1)){
                todos[i] = null;
            }else {
                todo[i] = todos[i + 1];
            }
        }
        return true;
    }

    private static boolean isSelectorTodoNotValid(final Integer number) {
        if (number <= 0) {
            return true;
        }
        if (todos[number - 1] == null){
            return true;
        }
        if (number - 1 > todos.length-1) {
            return true;
        }
        return false;
    }
    public static boolean editTodoList(Integer number, String newTodo){
        if(isSelectorTodoNotValid(number)){
            return false;
        }
        todos[number - 1] = newTodo;
        return true;
    }
    public static void showmainMenu(){
        boolean isRunning = true;
        while(isRunning){
            showTableTodo();
            System.out.println("Menu");
            System.out.println("Tambah");
            System.out.println("Hapus");
            System.out.println("edit");
            System.out.println("Keluar");
            String selectedMenu = scanner.nextLine();
            Switch(selectedMenu) {
                case 1 :
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    isRunning = false;
                    break;
                default:
                    System.out.println("Pilih menu dengan benar");
            }
        }
    }
}